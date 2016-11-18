package com.lq.ren.animator.object_ani;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author lqren on 16/11/10.
 */
public class CircleView extends View {

    private Circle mCircle = new Circle(100);
    private Paint mPaint = new Paint();

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300, 300, mCircle.getRadius(), mPaint);
    }

    /**
     * 这里的返回值为int,与动画ofInt的参数类型相同
     * 只有在仅有一个过渡值的时候会调用此方法
     * @return
     */

    public int getCircleRadius() {
        return 50;
    }

    /**
     * 第一点，这个 set 函数所对应的属性应该是 circleRadius 或者 CircleRadius。
     * 第二点，在 setPointRadius 中，先将当前动画传过来的值保存到 mCircle 中，做为当前圆形的半径。然后刷新界面.
     * @param radius
     */
    public void setCircleRadius(int radius) {
        mCircle.setRadius(radius);
        invalidate();
    }

    public void setCircle(Circle circle) {
        mCircle = circle;
        invalidate();
    }
}
