package ru.a799000.android.fandroidvktest.model;

import com.vk.sdk.api.model.Identifiable;

/**
 * Created by Alex on 15.09.2017.
 */

public interface Owner extends Identifiable {
    String getFullName();
    String getPhoto();
}
