package ru.a799000.android.fandroidvktest.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.model.view.NewsItemBodyViewModel;


/**
 * Created by user on 15.08.2017.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    private TextView tvText;

    private TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        tvText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        tvText.setText(item.getText());
        tvAttachments.setText(item.getmAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
        tvAttachments.setText(null);
    }
}