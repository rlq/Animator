package com.lq.ren.animator.scale;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lq.ren.animator.R;
import com.lq.ren.animator.object_ani.CircleView;

/**
 * Author lqren on 16/11/10.
 */
public class ScaleFragment extends Fragment {

    private ImageView mImage;
    private CircleView mCircleView;

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
                scaleImageAnimator();
                scaleCustomObjectAnimator();
            }
        });

        mCircleView = (CircleView) view.findViewById(R.id.circleView);
        mCircleView.setVisibility(View.VISIBLE);

    }

    private void scaleImageAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImage, "scaleY", 0, 0, 1);
        animator.setDuration(200);
        animator.start();
    }

    private void scaleImageAnimate() {
        mImage.animate().setDuration(200)
                .scaleY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mImage.animate().setDuration(200).scaleY(1f).start();
                    }
                })
                .start();
    }


    /**
     * 1. 动画绑定的是CircleView
     * 2. 属性circleRadius 从0 -> 30 -> 100
     * 3. 当动画只有一个过渡值时,系统会调用getCircleRadius()获取初始值.即ObjectAnimator.ofInt(mCircleView, "circleRadius", 100)
     *    如果在CircleView中没有该方法,则ofInt中使用的是int参数,系统默认初始值为0;
     */
    private void scaleCustomObjectAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofInt(mCircleView, "circleRadius", 0, 300, 100);
        animator.setDuration(2000);
        animator.start();
    }
}
