package ru.a799000.android.fandroidvktest.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.consts.ApiConstants;
import ru.a799000.android.fandroidvktest.model.Member;
import ru.a799000.android.fandroidvktest.model.view.BaseViewModel;
import ru.a799000.android.fandroidvktest.model.view.MemberViewModel;
import ru.a799000.android.fandroidvktest.mvp.view.BaseFeedView;
import ru.a799000.android.fandroidvktest.rest.api.GroupsApi;
import ru.a799000.android.fandroidvktest.rest.model.request.GroupsGetMembersRequestModel;


@InjectViewState
public class MembersPresenter extends BaseFeedPresenter<BaseFeedView>{

        @Inject
        GroupsApi mGroupsApi;

        public MembersPresenter() {
            MyApplication.getApplicationComponent().inject(this);
        }

        @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mGroupsApi.getMembers(new GroupsGetMembersRequestModel(
                ApiConstants.MY_GROUP_ID, count, offset).toMap())
            .flatMap(baseItemResponseFull -> {
                return Observable.fromIterable(baseItemResponseFull.response.getItems());
            })
            .doOnNext(member -> saveToDb(member))
            .map(member -> new MemberViewModel(member));
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .map(member -> new MemberViewModel(member));
    }

    public Callable<List<Member>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {Member.ID};
            Sort[] sortOrder = {Sort.ASCENDING};

            Realm realm = Realm.getDefaultInstance();
            RealmResults<Member> results = realm.where(Member.class)
                    .findAllSorted(sortFields, sortOrder);
            return realm.copyFromRealm(results);
        };
    }
}


















