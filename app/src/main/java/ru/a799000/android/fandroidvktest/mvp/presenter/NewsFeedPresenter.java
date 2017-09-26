package ru.a799000.android.fandroidvktest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.common.utils.VkListHelper;
import ru.a799000.android.fandroidvktest.model.WallItem;
import ru.a799000.android.fandroidvktest.model.view.BaseViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemBodyViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemFooterViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemHeaderViewModel;
import ru.a799000.android.fandroidvktest.mvp.view.BaseFeedView;
import ru.a799000.android.fandroidvktest.rest.api.WallApi;
import ru.a799000.android.fandroidvktest.rest.model.request.WallGetRequestModel;

/**
 * Created by user on 26.09.2017.
 */

//73476

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView> {

    @Inject
    WallApi mWallApi;


    public NewsFeedPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-73476, count, offset).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .doOnNext(this::saveToDb)
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));
                    return Observable.fromIterable(baseItems);
                });
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .flatMap(wallItem -> Observable.fromIterable(parsePojoModel(wallItem)));
    }


    private List<BaseViewModel> parsePojoModel(WallItem wallItem) {
        List<BaseViewModel> baseItems = new ArrayList<>();
        baseItems.add(new NewsItemHeaderViewModel(wallItem));
        baseItems.add(new NewsItemBodyViewModel(wallItem));
        baseItems.add(new NewsItemFooterViewModel(wallItem));
        return baseItems;
    }

    public Callable<List<WallItem>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {"date"};
            Sort[] sortOrder = {Sort.DESCENDING};
            Realm realm = Realm.getDefaultInstance();
            RealmResults<WallItem> realmResults = realm.where(WallItem.class)
                    .findAllSorted(sortFields, sortOrder);
            return realm.copyFromRealm(realmResults);
        };
    }
}
