package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    ProgressBar PB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PB=findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();


            }
        }).start();

    }
    private void doWork() {

        for (int progress = 0; progress < 100; progress += 10) {
            try {
                Thread.sleep(200);
                PB.setProgress(progress);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void startApp() {

        Intent intent = new Intent(Splash.this, Login.class);
        startActivity(intent);

    }
}
