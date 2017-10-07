package ru.a799000.android.fandroidvktest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.android.fandroidvktest.common.manager.NetworkManager;
import ru.a799000.android.fandroidvktest.di.module.ApplicationModule;
import ru.a799000.android.fandroidvktest.di.module.ManagerModule;
import ru.a799000.android.fandroidvktest.di.module.RestModule;
import ru.a799000.android.fandroidvktest.mvp.presenter.BoardPresenter;
import ru.a799000.android.fandroidvktest.mvp.presenter.InfoPresenter;
import ru.a799000.android.fandroidvktest.mvp.presenter.MainPresenter;
import ru.a799000.android.fandroidvktest.mvp.presenter.MembersPresenter;
import ru.a799000.android.fandroidvktest.mvp.presenter.NewsFeedPresenter;
import ru.a799000.android.fandroidvktest.ui.activity.BaseActivity;
import ru.a799000.android.fandroidvktest.ui.activity.MainActivity;
import ru.a799000.android.fandroidvktest.ui.fragment.NewsFeedFragment;
import ru.a799000.android.fandroidvktest.ui.holder.NewsItemBodyHolder;
import ru.a799000.android.fandroidvktest.ui.holder.NewsItemFooterHolder;

/**
 * Created by Alex on 18.08.2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);

    //holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);

    //presenters
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);

    //managers
    void inject(NetworkManager manager);
}
