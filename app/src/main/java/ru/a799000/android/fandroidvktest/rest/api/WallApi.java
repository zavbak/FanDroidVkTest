package ru.a799000.android.fandroidvktest.rest.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.a799000.android.fandroidvktest.rest.model.response.BaseItemResponse;
import ru.a799000.android.fandroidvktest.rest.model.response.Full;

/**
 * Created by Alex on 18.08.2017.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,

                                     @Query("access_token") String accessToken,

                                     @Query("extended") Integer extended,

                                     @Query("v") String version);
}
