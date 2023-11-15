package com.zafer.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int number = 0;
    Runnable runnable;
    Handler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView3);
        button = findViewById(R.id.button4);
    }
    public void startButton(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                handler.postDelayed(runnable , 1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);
    }
    public void cancelButton(View view){
        number = 0;
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time: " + number);
    }
}