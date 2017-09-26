package ru.a799000.android.fandroidvktest.mvp.view;

import com.arellomobile.mvp.MvpView;


import java.util.List;

import ru.a799000.android.fandroidvktest.model.view.BaseViewModel;

/**
 * Created by user on 28.08.2017.
 */

public interface BaseFeedView extends MvpView {
    void showRefreshing();

    void hideRefreshing();


    void showListProgress();

    void hideListProgress();


    void showError(String message);


    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}
