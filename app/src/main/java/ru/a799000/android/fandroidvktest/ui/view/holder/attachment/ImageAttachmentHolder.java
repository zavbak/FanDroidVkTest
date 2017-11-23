package ru.a799000.android.fandroidvktest.ui.view.holder.attachment;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.android.fandroidvktest.MyApplication;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.common.manager.MyFragmentManager;
import ru.a799000.android.fandroidvktest.model.view.attachment.ImageAttachmentViewModel;
import ru.a799000.android.fandroidvktest.ui.activity.BaseActivity;
import ru.a799000.android.fandroidvktest.ui.fragment.ImageFragment;
import ru.a799000.android.fandroidvktest.ui.view.holder.BaseViewHolder;


public class ImageAttachmentHolder extends BaseViewHolder<ImageAttachmentViewModel> {


    @BindView(R.id.iv_attachment_image)
    public ImageView image;

    @Inject
    MyFragmentManager mFragmentManager;


    public ImageAttachmentHolder(View itemView) {
        super(itemView);

        MyApplication.getApplicationComponent().inject(this);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ImageAttachmentViewModel imageAttachmentViewModel) {

        if (imageAttachmentViewModel.needClick) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFragmentManager.addFragment((BaseActivity) itemView.getContext(),
                            ImageFragment.newInstance(imageAttachmentViewModel.getPhotoUrl()), R.id.main_wrapper);
                }
            });
        }

        Glide.with(itemView.getContext()).load(imageAttachmentViewModel.getPhotoUrl()).into(image);


    }

    @Override
    public void unbindViewHolder() {

        itemView.setOnClickListener(null);
        image.setImageBitmap(null);
    }

}
