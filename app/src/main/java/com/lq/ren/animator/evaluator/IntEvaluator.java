package com.lq.ren.animator.evaluator;

import android.animation.TypeEvaluator;

/**
 * Author lqren on 16/11/12.
 */
public class IntEvaluator implements TypeEvaluator<Integer> {

    /**
     * 如果ofInt(0, 400),则此时返回值应该是(200, 600). reverse (400, 0);
     * @param fraction
     * @param startValue
     * @param endValue
     * @return
     */

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (200 + startInt + fraction * (endValue - startInt));
//        return (int) (endValue - fraction * (endValue - startValue));
    }
}
