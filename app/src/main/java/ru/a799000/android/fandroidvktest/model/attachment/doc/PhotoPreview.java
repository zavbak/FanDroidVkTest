package ru.a799000.android.fandroidvktest.model.attachment.doc;

import io.realm.RealmList;

/**
 * Created by user on 20.11.2017.
 */

public class PhotoPreview {

    RealmList<Size> sizes;


    public RealmList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(RealmList<Size> sizes) {
        this.sizes = sizes;
    }
}
