package ru.a799000.android.fandroidvktest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.android.fandroidvktest.di.module.ApplicationModule;
import ru.a799000.android.fandroidvktest.di.module.ManagerModule;
import ru.a799000.android.fandroidvktest.di.module.RestModule;
import ru.a799000.android.fandroidvktest.ui.activity.BaseActivity;
import ru.a799000.android.fandroidvktest.ui.activity.MainActivity;
import ru.a799000.android.fandroidvktest.ui.fragment.NewsFeedFragment;

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

}
