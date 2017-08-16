package ru.a799000.android.fandroidvktest;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Alex on 16.08.2017.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
