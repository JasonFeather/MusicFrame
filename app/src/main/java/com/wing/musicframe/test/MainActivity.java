package com.wing.musicframe.test;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.wing.musicframe.MusicFactory;
import com.wing.musicframe.pool.SoundPoolBase;
import com.wing.musicframe.test.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SoundPoolBase soudPool;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            soudPool.playSound("zhuan",1);
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MusicFactory musicFactory = new MusicFactory();

            soudPool = musicFactory.getSoudPool(this);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("zhuan");
        soudPool.load(strings);


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    Message message = handler.obtainMessage();
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                    }
                }

            }
        }).start();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
