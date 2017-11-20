package ru.a799000.android.fandroidvktest.rest.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import ru.a799000.android.fandroidvktest.consts.ApiConstants;

/**
 * Created by user on 20.11.2017.
 */

public class VideoGetReqestModel extends BaseRequestModel {

    @SerializedName(ApiConstants.VIDEOS)
    String videos;


    public VideoGetReqestModel(String ownerId, String videoId) {

        this.videos = ownerId + "_" + videoId;
    }

    public VideoGetReqestModel(int ownerId, int videoId) {

        this.videos = ownerId + "_" + videoId;
    }

    public VideoGetReqestModel(String videos) {
        this.videos = videos;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {
        map.put(ApiConstants.VIDEOS,getVideos());
    }
}
