package ru.a799000.android.fandroidvktest.model.view.counter;


import ru.a799000.android.fandroidvktest.model.Likes;

public class LikeCounterViewModel extends CounterViewModel{

    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;

        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}
