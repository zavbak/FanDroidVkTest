package ru.a799000.android.fandroidvktest;

import android.app.Application;

import com.vk.sdk.VKSdk;

import ru.a799000.android.fandroidvktest.di.component.ApplicationComponent;
import ru.a799000.android.fandroidvktest.di.component.DaggerApplicationComponent;
import ru.a799000.android.fandroidvktest.di.module.ApplicationModule;

/**
 * Created by Alex on 16.08.2017.
 */

public class MyApplication extends Application{

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        VKSdk.initialize(this);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
