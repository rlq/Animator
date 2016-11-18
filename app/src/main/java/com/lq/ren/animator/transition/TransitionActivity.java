package com.lq.ren.animator.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.lq.ren.animator.R;

/**
 * Author lqren on 16/11/14.
 */
public class TransitionActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transition);
        final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        Button nextButton = (Button) this.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(TransitionActivity.this, R.anim.view_transition_in_left);
                viewFlipper.setOutAnimation(TransitionActivity.this, R.anim.view_transition_out_left);
                viewFlipper.showNext();
            }

        });

        Button previousButton = (Button) this.findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, new TransitionFragment())
                        .commitAllowingStateLoss();
            }

        });


    }
}
