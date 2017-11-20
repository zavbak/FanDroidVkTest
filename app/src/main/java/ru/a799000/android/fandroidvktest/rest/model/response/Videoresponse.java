package ru.a799000.android.fandroidvktest.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.a799000.android.fandroidvktest.model.attachment.video.Video;

/**
 * Created by user on 20.11.2017.
 */

public class Videoresponse {

    public int count;

    @SerializedName("items")
    @Expose
    public List<Video> items;



}
