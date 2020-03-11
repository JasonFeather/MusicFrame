package com.wing.musicframe;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：音频播放器帮助类
 */

public class MediaPlayerHandle implements MyLifecycleObserver, MusicBase {
    MusicBase mediaPlayerImp;
    FragmentActivity fragmentActivity;
    Fragment fragment;


    public MediaPlayerHandle(FragmentActivity context) {
        fragmentActivity = context;
        mediaPlayerImp = new MediaPlayerImp(context);
        context.getLifecycle().addObserver(this);
    }

    public MediaPlayerHandle(Fragment context) {
        mediaPlayerImp = new MediaPlayerImp(context.getContext());
        context.getLifecycle().addObserver(this);
        fragment = context;
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        mediaPlayerImp.stopMusic();
        mediaPlayerImp.parseMusic();
        if (fragment != null) {
            fragment.getLifecycle().removeObserver(this);
        }
        if (fragmentActivity != null) {
            fragmentActivity.getLifecycle().removeObserver(this);
        }
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        mediaPlayerImp.stopMusic();
    }

    @Override
    public void onResume(LifecycleOwner owner) {

    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {

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
    public void setURLAndStart(String name,boolean isRepeat) {
       mediaPlayerImp.setURLAndStart(name,isRepeat);
    }
}
