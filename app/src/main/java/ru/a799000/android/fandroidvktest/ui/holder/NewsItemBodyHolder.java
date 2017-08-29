package ru.a799000.android.fandroidvktest.ui.holder;

import android.view.View;
import android.widget.TextView;

import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.model.view.NewsItemBodyViewModel;


/**
 * Created by user on 15.08.2017.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    public TextView tvText;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        tvText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        tvText.setText(item.getText());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
    }
}
