package ru.a799000.android.fandroidvktest.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 18.08.2017.
 */

public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;
}
