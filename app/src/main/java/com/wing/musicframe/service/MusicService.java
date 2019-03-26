package com.wing.musicframe.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public class MusicService extends Service {
    public  MusicBinder musicBinder = new MusicBinder(this);
    @Override
    public IBinder onBind(Intent intent) {
        return musicBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        musicBinder.stopMusic();
        musicBinder.relaseMusic();
        return super.onUnbind(intent);

    }

}
