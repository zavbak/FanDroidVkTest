package ru.a799000.android.fandroidvktest.ui.fragment;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.common.utils.VkListHelper;
import ru.a799000.android.fandroidvktest.model.WallItem;
import ru.a799000.android.fandroidvktest.model.view.BaseViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemBodyViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemFooterViewModel;
import ru.a799000.android.fandroidvktest.model.view.NewsItemHeaderViewModel;
import ru.a799000.android.fandroidvktest.mvp.presenter.BaseFeedPresenter;
import ru.a799000.android.fandroidvktest.mvp.presenter.NewsFeedPresenter;
import ru.a799000.android.fandroidvktest.rest.api.WallApi;
import ru.a799000.android.fandroidvktest.rest.model.request.WallGetRequestModel;
import ru.a799000.android.fandroidvktest.rest.model.response.GetWallResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    @InjectPresenter
    NewsFeedPresenter mPresenter;


    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}
