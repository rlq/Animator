package com.lq.ren.animator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

import com.lq.ren.animator.evaluator.EvaluatorFragment;
import com.lq.ren.animator.rotate.RotateFragment;
import com.lq.ren.animator.scale.ScaleFragment;
import com.lq.ren.animator.translate.TranslateFragment;
import com.lq.ren.animator.utils.UIUtils;

/**
 * Author lqren on 16/11/11.
 */
public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade());
        getWindow().setReturnTransition(new Explode());

        String title = getIntent().getStringExtra(UIUtils.TITLE);
        Fragment fragment;
        switch (title) {
            case UIUtils.ALPHA:
                fragment = new RotateFragment();
                break;
            case UIUtils.SCALE:
                fragment = new ScaleFragment();
                break;
            case UIUtils.TRANSLATE:
                fragment = new TranslateFragment();
                break;
            case UIUtils.ROTATE:
                fragment = new RotateFragment();
                break;
            case UIUtils.EVALUATOR:
                fragment = new EvaluatorFragment();
                break;
            default:
                fragment = null;
                break;
        }

        if (fragment != null) {
            fragment.setAllowEnterTransitionOverlap(false);
            fragment.setEnterTransition(new Slide(Gravity.RIGHT));
            fragment.setExitTransition(new Slide(Gravity.LEFT));
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commitAllowingStateLoss();
        } else {
            finish();
        }
    }
}
