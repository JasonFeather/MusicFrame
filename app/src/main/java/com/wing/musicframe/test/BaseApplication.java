package com.wing.musicframe.test;

import android.app.Application;

import com.wing.musicframe.MusicFactory;
import com.wing.musicframe.pool.SoundPoolBase;

import java.util.ArrayList;

/**
 * Created by dell on 2019/7/8.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//         MusicFactory musicFactory = new MusicFactory();
//        SoundPoolBase soudPool = musicFactory.getSoudPool(this);
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("music2");
//        soudPool.load(strings);
    }
}
