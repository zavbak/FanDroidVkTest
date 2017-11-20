package ru.a799000.android.fandroidvktest.model.attachment.video;

import io.realm.RealmObject;

/**
 * Created by user on 20.11.2017.
 */

public class File extends RealmObject {

    public String external;

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }
}
