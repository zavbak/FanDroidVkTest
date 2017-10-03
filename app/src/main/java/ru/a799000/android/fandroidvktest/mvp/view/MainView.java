package ru.a799000.android.fandroidvktest.mvp.view;

import com.arellomobile.mvp.MvpView;

import ru.a799000.android.fandroidvktest.model.Profile;
import ru.a799000.android.fandroidvktest.ui.fragment.BaseFragment;

/**
 * Created by Alex on 16.08.2017.
 */

public interface MainView extends MvpView {
    void startSignIn();
    void signedIn();
    void showCurrentUser(Profile profile);
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
