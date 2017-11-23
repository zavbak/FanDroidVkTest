package ru.a799000.android.fandroidvktest.ui.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Alex on 29.08.2017.
 */

public abstract class BaseViewHolder<Item> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}
