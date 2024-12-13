package com.example.counter4b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bstart,bstop;
    TextView ctr;
    int counter=0;
    Boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       bstart=(Button) findViewById(R.id.btn_start);
       bstop=(Button) findViewById(R.id.btn_stop);
       ctr=(TextView) findViewById(R.id.countervalue);
       bstart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               counter=0;
               running=true;
               mycounter();
           }
       });
        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;

            }
        });

    }
    Handler handler=new Handler()
    {
        public void handleMessage(Message message)
        {
            ctr.setText(String.valueOf(message.what));
        }
    };

    Class mycounter()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(running) {
                    counter++;
                    handler.sendEmptyMessage(counter);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        return null;
    }
}