package ru.a799000.android.fandroidvktest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.android.fandroidvktest.common.manager.MyFragmentManager;
import ru.a799000.android.fandroidvktest.common.manager.NetworkManager;

/**
 * Created by Alex on 18.08.2017.
 */

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }
}
