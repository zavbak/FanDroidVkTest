package ru.a799000.android.fandroidvktest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.a799000.android.fandroidvktest.CurrentUser;
import ru.a799000.android.fandroidvktest.mvp.view.MainView;

/**
 * Created by Alex on 16.08.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedIn();
        }
    }
}
