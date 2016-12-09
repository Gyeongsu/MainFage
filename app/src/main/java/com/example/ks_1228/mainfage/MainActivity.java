package com.example.ks_1228.mainfage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    Thread myThread;
    private int i = 0;
    private int mod;
    private TextView myi;
    private ImageView imageView;
    Intent intent = null, intent02 = null, intent03 = null, intent04 = null;
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            updateThread();
        }
    };

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onStart() {
        super.onStart();

        myThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(1500);
                    } catch (Throwable t) {
                    }
                }
            }
        });

        myThread.start();

    }


    private void updateThread() {
        mod = i%4;
        switch (mod) {
            case 0:
                i++;
                imageView.setImageResource(R.drawable.cfood03);
                break;
            case 1:
                i++;
                imageView.setImageResource(R.drawable.cfood02);
                break;
            case 2:
                i++;
                imageView.setImageResource(R.drawable.cfood01);
                break;
            case 3:
                i = 0;
                imageView.setImageResource(R.drawable.kfood01);
                break;
        }
        myi.setText(String.valueOf(i));
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myi = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        intent = new Intent(this, Sub.class);
        intent02 = new Intent(this, Sub.class);
        intent03 = new Intent(this, Sub.class);
        intent04 = new Intent(this, Sub.class);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mod == 1) {
                    startActivity(intent);
                }
            }
        });
    }
}