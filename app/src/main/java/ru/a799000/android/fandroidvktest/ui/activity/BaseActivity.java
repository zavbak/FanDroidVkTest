package ru.a799000.android.fandroidvktest.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;


import javax.inject.Inject;

import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.common.manager.MyFragmentManager;
import ru.a799000.android.fandroidvktest.ui.fragment.BaseFragment;

/**
 * Created by Alex on 16.08.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

   @Inject
   MyFragmentManager myFragmentManager;

   protected ProgressBar mProgressBar;

   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      MyApplication.getApplicationComponent().inject(this);

      setContentView(R.layout.activity_base);

      mProgressBar = (ProgressBar) findViewById(R.id.progress);


      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
      getLayoutInflater().inflate(getMainContentLayout(), parent);
   }


   @LayoutRes
   protected abstract int getMainContentLayout();

   public void fragmentOnScreen(BaseFragment baseFragment){
      setToolbarTitle(baseFragment.createToolbarTitle(this));
   }

   private void setToolbarTitle(String title) {
      if (getSupportActionBar() != null) {
         getSupportActionBar().setTitle(title);
      }
   }

   public void setContent(BaseFragment fragment) {
      myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
   }

   public void addContent(BaseFragment fragment) {
      myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
   }

   public boolean removeCurrentFragment() {
      return myFragmentManager.removeCurrentFragment(this);
   }

   public boolean removeFragment(BaseFragment fragment) {
      return myFragmentManager.removeFragment(this, fragment);
   }


   @Override
   public void onBackPressed() {
      removeCurrentFragment();
   }

   public ProgressBar getProgressBar() {
      return mProgressBar;
   }

}
