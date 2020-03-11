package com.wing.musicframe.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wing.musicframe.MusicBase;
import com.wing.musicframe.MusicFactory;
import com.wing.musicframe.pool.SoundPoolBase;


public class MainActivity extends AppCompatActivity {

    private SoundPoolBase soudPool;
    private MusicBase normalMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MusicFactory musicFactory = new MusicFactory();
        normalMusic = musicFactory.getNormalMusic(this);
        normalMusic.initMusic();
        soudPool = musicFactory.getSoudPool(this);
        findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                soudPool.playSound("music2",0);
                normalMusic.setURLAndStart("music1.mp3",true);

            }
        });
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               normalMusic.stopMusic();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
