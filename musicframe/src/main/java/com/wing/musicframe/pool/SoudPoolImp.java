package com.wing.musicframe.pool;


import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 姓名：张金齐
 * 日期：2019/3/26
 * 用途功能：
 */

public class SoudPoolImp implements SoundPoolBase, SoundPool.OnLoadCompleteListener {
    private static SoudPoolImp soudPoolImp = null;
    private Context mContext;
    private SoundPool mSoundPoll;
    HashMap<String, Integer> sounddata=new HashMap<>();
    private boolean isLoaded;

    private ArrayList<Integer>  playSoudIdList=new ArrayList<>();

    private SoudPoolImp() {

    }

    private SoudPoolImp(Context context) {
        mContext = context;
        AudioAttributes abs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        mSoundPoll = new SoundPool.Builder()
                .setMaxStreams(100)   //设置允许同时播放的流的最大值
                .setAudioAttributes(abs)   //完全可以设置为null
                .build();
    }

    public static SoudPoolImp getInstance(Context context) {
        if (soudPoolImp == null) {
            synchronized (SoudPoolImp.class) {
                if (soudPoolImp == null) {
                    soudPoolImp=new SoudPoolImp(context);
                    return soudPoolImp;
                }
            }
        }
        return soudPoolImp;
    }

    @Override
    public void load(ArrayList<String> list) {
        for (String item :
                list) {
            final int drawRes = mContext.getResources().getIdentifier(item, "raw", mContext.getPackageName());
            sounddata.put(item, mSoundPoll.load(mContext, drawRes, 1));
        }
        mSoundPoll.setOnLoadCompleteListener(this);
    }

    @Override
    public void stop(String name) {
        mSoundPoll.stop(sounddata.get(name));
    }

    @Override
    public void stop(int id) {
        mSoundPoll.stop(id);
    }

    @Override
    public void pause(String name) {
        mSoundPoll.pause(sounddata.get(name));
    }

    @Override
    public void resume(String name) {
        mSoundPoll.resume(sounddata.get(name));
    }

    @Override
    public void release() {
        mSoundPoll.release();
    }

    @Override
    public void setLoop(String name, int loop) {
        mSoundPoll.setLoop(sounddata.get(name), loop);
    }

    @Override
    public void setPriority(String name, int priority) {
        mSoundPoll.setPriority(sounddata.get(name), priority);
    }

    @Override
    public void setRate(String name, float rate) {
        mSoundPoll.setRate(sounddata.get(name), rate);
    }

    @Override
    public void setVolume(String name, float leftVolume, float rightVolume) {
        mSoundPoll.setVolume(sounddata.get(name), leftVolume,rightVolume);
    }

    @Override
    public int playSound(String name, int number) {
        if(isLoaded){
            AudioManager am = (AudioManager) mContext
                    .getSystemService(Context.AUDIO_SERVICE);
            float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            float volumnCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC);
            float volumnRatio = volumnCurrent / audioMaxVolumn;
            int play = mSoundPoll.play(sounddata.get(name),
                    volumnRatio,// 左声道音量
                    volumnRatio,// 右声道音量
                    1, // 优先级
                    number,// 循环播放次数
                    1);// 回放速度，该值在0.5-2.0之间 1为正常速度
            playSoudIdList.add(play);
            return play;
        }
        return 0;
    }

    @Override
    public void stopAll() {
        for (int i = 0; i <playSoudIdList.size() ; i++) {
            mSoundPoll.stop(playSoudIdList.get(i));
        }
        playSoudIdList.clear();
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        isLoaded = true;
    }
}
