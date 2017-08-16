package ru.a799000.android.fandroidvktest.ui.fragment;




import ru.a799000.android.fandroidvktest.R;


public class NewsFeedFragment extends BaseFragment {


    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }



    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

}
