package ru.a799000.android.fandroidvktest.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.android.fandroidvktest.model.Profile;
import ru.a799000.android.fandroidvktest.rest.model.response.Full;
import ru.a799000.android.fandroidvktest.rest.model.response.Videoresponse;

/**
 * Created by user on 20.11.2017.
 */

public interface VideoApi {

    @GET(ApiMethods.VIDEO_GET)
    Observable<Full<Videoresponse>> get(@QueryMap Map<String, String> map);
}
