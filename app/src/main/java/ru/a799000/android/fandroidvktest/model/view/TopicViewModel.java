package ru.a799000.android.fandroidvktest.model.view;


import android.view.View;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.android.fandroidvktest.R;
import ru.a799000.android.fandroidvktest.model.Topic;
import ru.a799000.android.fandroidvktest.ui.holder.BaseViewHolder;

public class TopicViewModel extends  BaseViewModel{

    private int mid;
    private int mGroupid;
    private String mTitle;
    private String mCommentsCount;

    public TopicViewModel() {
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.Topic;
    }

    public TopicViewModel(Topic topic) {
        this.mid = topic.getId();
        this.mGroupid = topic.getGroupid();
        this.mTitle = topic.getTitle();
        this.mCommentsCount = topic.getComments() + " сообщений";
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new TopicViewHolder(view);
    }

    public int getMid() {
        return mid;
    }

    public int getGroupid() {
        return mGroupid;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCommentsCount() {
        return mCommentsCount;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setGroupid(int mGroupid) {
        this.mGroupid = mGroupid;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setCommentsCount(String mCommentsCount) {
        this.mCommentsCount = mCommentsCount;
    }

    public static class TopicViewHolder extends BaseViewHolder<TopicViewModel> {

        @BindView(R.id.tv_title)
        public TextView tvTitle;

        @BindView(R.id.tv_comments_count)
        public TextView tvCommentsCount;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(TopicViewModel topicViewModel) {
            tvTitle.setText(topicViewModel.getTitle());
            tvCommentsCount.setText(topicViewModel.getCommentsCount());

        }

        @Override
        public void unbindViewHolder() {
            tvTitle.setText(null);
            tvCommentsCount.setText(null);

        }
    }
}

























