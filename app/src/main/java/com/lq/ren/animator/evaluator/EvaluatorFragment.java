package com.lq.ren.animator.evaluator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.lq.ren.animator.R;
import com.lq.ren.animator.object_ani.Circle;
import com.lq.ren.animator.object_ani.CircleView;

/**
 * Author lqren on 16/11/12.
 */
public class EvaluatorFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        doCharAnimator(view);
        doBoundAnimator(view);
        doPropertyAnimator(view);
    }

    private void doCharAnimator(View view) {
        final TextView textView = (TextView) view.findViewById(R.id.evaluator_text);
        textView.setVisibility(View.VISIBLE);
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),
                new Character('A'), new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char text = (char) valueAnimator.getAnimatedValue();
                textView.setText("" + text);
            }
        });
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void doBoundAnimator(View view) {
        final CircleView circleView = (CircleView) view.findViewById(R.id.circleView);
        circleView.setVisibility(View.VISIBLE);
        ValueAnimator animator = ValueAnimator.ofObject(new BoundEvaluator(), new Circle(20),
                new Circle(300));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Circle curPoint = (Circle) valueAnimator.getAnimatedValue();
                circleView.setCircle(curPoint);
            }
        });
        animator.setDuration(1000);
        animator.setRepeatCount(5);
        animator.start();
    }

    /**
     * setCharText,因为Text中没有setText(Character character)这样的函数
     * @param view
     */
    private void doPropertyAnimator(View view) {
        final CharPropertyText textView = (CharPropertyText) view.findViewById(R.id.property_text);
        textView.setVisibility(View.VISIBLE);
        PropertyValuesHolder charHolder = PropertyValuesHolder.ofObject("CharText",
                new CharEvaluator(), new Character('A'), new Character('Z'));
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, charHolder);
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }
}
