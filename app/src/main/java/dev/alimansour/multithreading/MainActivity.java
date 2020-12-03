package dev.alimansour.multithreading;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("MainActivity", "Debug Logger");
//        Log.e("MainActivity", "Error Logger");
//        Log.v("MainActivity", "Verbose Logger");
//        Log.i("MainActivity", "Information logger");
//        Log.w("MainActivity", "Warning Logger");
//
//        try {
//            int x = 10;
//            int y = 0;
//            int result = x / y;
//        } catch (Exception e) {
//            Toast.makeText(this, "Invalid process", Toast.LENGTH_LONG).show();
//            Log.e("MainActivity", e.getLocalizedMessage());
//        }

       /* Thread backgroundThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(50000);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        backgroundThread.start();*/

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}