package com.example.administrator.surfaceview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout stage = (FrameLayout) findViewById(R.id.stage);

        StageView stageView = new StageView(this);

        stage.addView(stageView);

    }
}
