package ru.a799000.android.fandroidvktest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import ru.a799000.android.fandroidvktest.CurrentUser;
import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.common.manager.NetworkManager;
import ru.a799000.android.fandroidvktest.model.Profile;
import ru.a799000.android.fandroidvktest.mvp.view.MainView;
import ru.a799000.android.fandroidvktest.rest.api.UsersApi;
import ru.a799000.android.fandroidvktest.rest.model.request.UsersGetRequestModel;

/**
 * Created by Alex on 16.08.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    UsersApi mUserApi;

    @Inject
    NetworkManager mNetworkManager;

    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getCurrentUser();
            getViewState().signedIn();
        }
    }

    public Observable<Profile> getProfileFromNetwork() {
        return mUserApi.get(new UsersGetRequestModel(CurrentUser.getId()).toMap())
                .flatMap(listFull -> Observable.fromIterable(listFull.response))
                .doOnNext(this::saveToDb);
    }

    private Observable<Profile> getProfileFromDb() {
        return Observable.fromCallable(getListFromRealmCallable());
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(item));
    }

    public Callable<Profile> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            Profile realmResults = realm.where(Profile.class)
                    .equalTo("id", Integer.parseInt(CurrentUser.getId()))
                    .findFirst();
            return realm.copyFromRealm(realmResults);
        };
    }

    private void getCurrentUser() {
        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                    if (!CurrentUser.isAuthorized()) {
                        getViewState().startSignIn();
                    }

                    return aBoolean
                            ? getProfileFromNetwork()
                            : getProfileFromDb();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    getViewState().showCurrentUser(profile);
                }, error -> {
                    error.printStackTrace();
                });
    }

}
