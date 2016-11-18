package com.lq.ren.animator.rotate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.lq.ren.animator.R;

/**
 * Author lqren on 16/11/10.
 */
public class RotateFragment extends Fragment {

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
                rotateImageAnimator();
            }
        });
    }

    /**
     * rotate
     */

    private void rotateAnimation() {

    }

    private void rotateImageAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImage, "rotationY", 0, 360, 1);
        animator.setDuration(200);
        animator.start();
    }

    private void rotateImageAnimate() {
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

    private void Rotate3dImage() {
        Rotate3d animation = new Rotate3d(0, 0, 360,
                mImage.getWidth() / 2, mImage.getHeight() / 2, 310f);
        animation.setDuration(200);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImage.startAnimation(animation);
    }
}
