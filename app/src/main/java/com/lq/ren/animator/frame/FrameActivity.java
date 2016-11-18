package com.lq.ren.animator.frame;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.lq.ren.animator.R;

/**
 * Author lqren on 16/11/18.
 */
public class FrameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_image);

        ImageView image = (ImageView) findViewById(R.id.image);
        image.setBackgroundResource(R.drawable.drawable_animation);
        AnimationDrawable animation = (AnimationDrawable) image.getBackground();
//        animation.addFrame(getResources().getDrawable(R.drawable.frame1), 200);
//        animation.addFrame(getResources().getDrawable(R.drawable.frame2), 200);
//        animation.addFrame(getResources().getDrawable(R.drawable.frame3), 200);
        animation.start();
    }
}
