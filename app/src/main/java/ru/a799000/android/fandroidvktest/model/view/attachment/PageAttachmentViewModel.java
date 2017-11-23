package ru.a799000.android.fandroidvktest.model.view.attachment;

import android.view.View;

import ru.a799000.android.fandroidvktest.model.attachment.Page;
import ru.a799000.android.fandroidvktest.model.view.BaseViewModel;
import ru.a799000.android.fandroidvktest.ui.view.holder.attachment.PageAttachmentHolder;


public class PageAttachmentViewModel extends BaseViewModel {

    private String mTitle;
    private String mUrl;

    public PageAttachmentViewModel(Page page) {
        mUrl = page.getUrl();
        mTitle = page.getTitle();
    }

    public String getTitle() {
        return mTitle;
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentPage;
    }

    @Override
    public PageAttachmentHolder onCreateViewHolder(View view) {
        return new PageAttachmentHolder(view);
    }



    public String getmUrl() {
        return mUrl;
    }
}
