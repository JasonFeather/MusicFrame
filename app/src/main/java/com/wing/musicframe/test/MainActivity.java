package com.wing.musicframe.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wing.musicframe.MusicBase;
import com.wing.musicframe.MusicFactory;
import com.wing.musicframe.pool.SoundPoolBase;

public class MainActivity extends AppCompatActivity {
    MusicBase servieMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final MusicFactory musicFactory = new MusicFactory();
         servieMusic = musicFactory.getServieMusic(this);
        servieMusic.setURLAndStart("mian_bg.mp3",true);
        findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundPoolBase soudPool = musicFactory.getSoudPool(MainActivity.this);
                soudPool.playSound("zhuan",1);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        servieMusic.parseMusic();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        servieMusic.startMusic();
    }
}
