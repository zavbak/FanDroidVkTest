package ru.a799000.android.fandroidvktest.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

import ru.a799000.android.fandroidvktest.CurrentUser;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.consts.ApiConstants;
import ru.a799000.android.fandroidvktest.mvp.presenter.MainPresenter;
import ru.a799000.android.fandroidvktest.mvp.view.MainView;
import ru.a799000.android.fandroidvktest.ui.fragment.NewsFeedFragment;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.checkAuth();

        //VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);

        //String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        //Log.d("MainActivity", "Fingerprint: " + Arrays.toString(fingerprints));

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>(){
                    @Override
                    public void onResult(VKAccessToken res) {
                        // Пользователь успешно авторизовался
                        mPresenter.checkAuth();
                    }

                    @Override
                    public void onError(VKError error) {
                        // Произошла ошибка авторизации(например, пользователь запретил авторизацию)
                    }})
                ) {


            super.onActivityResult(requestCode, resultCode, data);
        }


    }


    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedIn() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(), Toast.LENGTH_LONG).show();
        setContent(new NewsFeedFragment());
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }
}
