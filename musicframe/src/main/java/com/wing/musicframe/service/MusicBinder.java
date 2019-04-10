package com.wing.musicframe.service;

import android.content.Context;
import android.os.Binder;

import com.wing.musicframe.MediaPlayerImp;
import com.wing.musicframe.MusicBase;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public class MusicBinder extends Binder implements MusicBase {
    private Context mContext;
    private MusicBase mediaPlayerImp;
    public MusicBinder(Context context){
        mContext=context;
        mediaPlayerImp=new MediaPlayerImp(context);
    }
    @Override
    public void startMusic() {
        mediaPlayerImp.startMusic();
    }

    @Override
    public void stopMusic() {
        mediaPlayerImp.stopMusic();
    }

    @Override
    public void parseMusic() {
        mediaPlayerImp.parseMusic();
    }

    @Override
    public void initMusic() {
    }

    @Override
    public void relaseMusic() {
        mediaPlayerImp.relaseMusic();
    }

    @Override
    public void setURLAndStart(String name,boolean isRepeart) {
        mediaPlayerImp.setURLAndStart(name,isRepeart);
    }
}
