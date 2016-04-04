package com.example.prx.chronometertest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.test);
        startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置开始计时时间
                chronometer.setBase(SystemClock.elapsedRealtime());
                //启动计时器
                chronometer.start();
            }
        });
        //为Chronometer绑定监听事件
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //如果从开始计时超过了20秒
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 20*1000){
                    chronometer.stop();
                    startBtn.setEnabled(true);
                }
            }
        });
    }
}
