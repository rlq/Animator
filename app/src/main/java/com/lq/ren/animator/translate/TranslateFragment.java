package com.lq.ren.animator.translate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lq.ren.animator.R;

/**
 * Author lqren on 16/11/10.
 */
public class TranslateFragment extends Fragment {

    private ImageView mImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImage = (ImageView) view.findViewById(R.id.image);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translateValueAnimator();
            }
        });
    }

    //PropertyAnimator

    /**
     * 在监听过程中,通过layout设置ImageView的位置,同时ImageView的响应区域随位置而移动.
     * ImageView从(0,0)-->(400, 400)移动
     */
    private void translateValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                mImage.layout(curValue, curValue, curValue + mImage.getWidth(), curValue + mImage.getHeight());
            }
        });
        animator.start();
    }

    private void translateObjectAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImage, "translteY", 0, 0, 1);
        animator.setDuration(200);
        animator.start();
    }

    private void translateImageAnimate() {
        mImage.animate().setDuration(200)
                .translationY(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mImage.animate().setDuration(200).scaleY(1f).start();
                    }
                })
                .start();
    }

    private void tanslateImage() {

    }
}
