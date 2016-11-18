package com.lq.ren.animator.evaluator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author lqren on 16/11/12.
 */
public class CharPropertyText extends TextView {

    public CharPropertyText(Context context) {
        super(context);
    }

    public CharPropertyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CharPropertyText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCharText(Character charText) {
        setText("" + charText);
    }
}
