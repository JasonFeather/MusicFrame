package com.wing.musicframe.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.wing.musicframe.MusicBase;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public class MusicSeviceHandle implements MusicBase {
    private static MusicSeviceHandle musicSeviceHandle = null;
    private MusicBinder musicBinder;

    private MusicSeviceHandle(){}
    private MusicSeviceHandle(Context context) {
        Intent intent = new Intent(context, MusicService.class);
        context.getApplicationContext().bindService(intent,getConnection(),BIND_AUTO_CREATE);
    }

    public static MusicSeviceHandle getInstance(Context context) {
        if (musicSeviceHandle == null) {
            synchronized (MusicSeviceHandle.class) {
                if (musicSeviceHandle == null) {
                    return new MusicSeviceHandle(context);
                }
            }
        } else {
            return musicSeviceHandle;
        }

        return musicSeviceHandle;
    }


    @Override
    public void startMusic() {
        musicBinder.startMusic();
    }

    @Override
    public void stopMusic() {
        musicBinder.stopMusic();
    }

    @Override
    public void parseMusic() {

    }

    @Override
    public void initMusic() {

    }

    @Override
    public void relaseMusic() {

    }

    @Override
    public void setURLAndStart(String name,boolean isRepeat) {
        musicBinder.setURLAndStart(name,isRepeat);
    }

    private ServiceConnection getConnection() {
        return new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                musicBinder = (MusicBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                musicBinder = null;
            }
        };
    }
}
