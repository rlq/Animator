package com.lq.ren.animator.evaluator;

import android.animation.TypeEvaluator;

import com.lq.ren.animator.object_ani.Circle;

/**
 * Author lqren on 16/11/12.
 */
public class BoundEvaluator implements TypeEvaluator<Circle> {

    @Override
    public Circle evaluate(float fraction, Circle startValue, Circle endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int curValue = (int) (start + fraction * (end - start));
        return new Circle(curValue);
    }
}
