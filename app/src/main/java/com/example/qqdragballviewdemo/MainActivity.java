package com.example.qqdragballviewdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button resetBtn, refresh;
    private DragBallView dragBallView;
    int offsetY = 10;
    Timer mTimer = new Timer();
    TimerTask mTimerTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetBtn = findViewById(R.id.reset_btn);
        dragBallView = findViewById(R.id.drag_ball_view);
        refresh = findViewById(R.id.refresh);

        dragBallView.setOnDragBallListener(new DragBallView.OnDragBallListener() {
            @Override
            public void onDisappear() {
                offsetY = 10;
                Toast.makeText(MainActivity.this, "消失了", Toast.LENGTH_SHORT).show();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offsetY = 10;
                dragBallView.reset();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity===", "offsetY==" + offsetY);
                if (offsetY <= 170) {
                    dragBallView.setPercent(offsetY);
                    offsetY = offsetY + 10;
                }else{
                    offsetY = 10;
                    dragBallView.reset();
                }
            }
        });
    }
}
