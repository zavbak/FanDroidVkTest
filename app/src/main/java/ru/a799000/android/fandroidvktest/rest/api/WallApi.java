package ru.a799000.android.fandroidvktest.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.android.fandroidvktest.rest.model.response.GetWallResponse;

/**
 * Created by Alex on 18.08.2017.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);
}
