package com.lq.ren.animator.transition;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lq.ren.animator.R;

/**
 * Author lqren on 16/11/14.
 */
public class TransitionFragment extends Fragment implements View.OnClickListener {

    ViewGroup mRoot;
    Scene mScene1;
    Scene mScene2;
    TransitionManager manager;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition, container, false);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRoot = (ViewGroup) view.findViewById(R.id.transition_root);
        mScene1 = Scene.getSceneForLayout(mRoot, R.layout.view_transition_scene1, getContext());
        mScene2 = Scene.getSceneForLayout(mRoot, R.layout.view_transition_scene2, getContext());

//        TransitionManager.go(mScene2);
//        Transition fadeTransition = new Fade();
//        Transition transition = TransitionInflater.from(getContext()).inflateTransition(R.transition.fade_transition);
//        TransitionManager.beginDelayedTransition(mRoot, fadeTransition);
        mRoot.findViewById(R.id.scene1).setOnClickListener(this);

        manager = TransitionInflater.from(getContext()).inflateTransitionManager(R.transition.transition_manager, mRoot);
//        manager.transitionTo(mScene2);
    }

    public void openScene1() {
        //manager.go(mScene1, new Fade(Fade.IN));
        TransitionManager.go(mScene1);
        TransitionManager.beginDelayedTransition(mRoot, new ChangeColor());
        mRoot.findViewById(R.id.scene1).setOnClickListener(this);
        ((TextView) mRoot.findViewById(R.id.transition_text)).setText("已切换");
    }

    public void openScene2() {
        manager.go(mScene2, new Fade(Fade.OUT));
        mRoot.findViewById(R.id.scene2).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scene1:
                openScene1();
                break;
            case R.id.scene2:
                openScene1();
                break;
        }
    }
}
