package ru.a799000.android.fandroidvktest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.android.fandroidvktest.rest.RestClient;
import ru.a799000.android.fandroidvktest.rest.api.WallApi;

/**
 * Created by Alex on 18.08.2017.
 */
@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
       return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
