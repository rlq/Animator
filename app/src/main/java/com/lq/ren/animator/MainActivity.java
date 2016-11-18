package com.lq.ren.animator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lq.ren.animator.frame.FrameActivity;
import com.lq.ren.animator.transition.TransitionActivity;
import com.lq.ren.animator.utils.UIUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.rotate).setOnClickListener(this);
        findViewById(R.id.evaluator).setOnClickListener(this);
        findViewById(R.id.frame).setOnClickListener(this);
        findViewById(R.id.transition).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        boolean isFragment = true;
        Intent intent = new Intent(this, DetailsActivity.class);
        String title = "";
        switch (view.getId()) {
            case R.id.alpha:
                title = UIUtils.ALPHA;
                break;
            case R.id.scale:
                title = UIUtils.SCALE;
                break;
            case R.id.translate:
                title = UIUtils.TRANSLATE;
                break;
            case R.id.rotate:
                title = UIUtils.ROTATE;
                break;
            case R.id.evaluator:
                title = UIUtils.EVALUATOR;
                break;
            case R.id.frame:
                isFragment = false;
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.transition:
                isFragment = false;
                startActivity(new Intent(this, TransitionActivity.class));
                break;
            default:
                break;
        }
        if (isFragment) {
            intent.putExtra(UIUtils.TITLE, title);
            startActivity(intent);
        }
    }



}
