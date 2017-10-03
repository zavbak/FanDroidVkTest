package ru.a799000.android.fandroidvktest.rest.api;




import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.android.fandroidvktest.model.Member;
import ru.a799000.android.fandroidvktest.rest.model.response.BaseItemResponse;
import ru.a799000.android.fandroidvktest.rest.model.response.Full;

public interface GroupsApi {

    @GET(ApiMethods.GROUPS_GET_MEMBERS)
    Observable<Full<BaseItemResponse<Member>>> getMembers(@QueryMap Map<String, String> map);
}
