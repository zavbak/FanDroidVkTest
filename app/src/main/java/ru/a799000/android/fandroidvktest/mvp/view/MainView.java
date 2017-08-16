package ru.a799000.android.fandroidvktest.mvp.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Alex on 16.08.2017.
 */

public interface MainView extends MvpView {
    void startSignIn();
    void signedIn();
}
