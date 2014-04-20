package com.includeit.transitionmanager.app;

import android.app.Activity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;


public class MainActivity extends Activity implements
        RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private Scene scene1,scene2,scene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        ViewGroup viewGroup=(FrameLayout)findViewById(R.id.rootContainer);

        scene1=Scene.getSceneForLayout(viewGroup,R.layout.scene1,this);
        scene2=Scene.getSceneForLayout(viewGroup,R.layout.scene2,this);
        scene3=Scene.getSceneForLayout(viewGroup,R.layout.scene3,this);


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        switch (id)
        {
            case R.id.rdScene1:
                TransitionManager.go(scene1,new ChangeBounds());
                break;
            case R.id.rdScene2:
                TransitionManager.go(scene2,new ChangeBounds());
                break;
            case R.id.rdScene3:
                TransitionManager.go(scene3,new ChangeBounds());
                break;
        }
    }
}
