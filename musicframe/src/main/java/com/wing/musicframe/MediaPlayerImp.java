package com.wing.musicframe;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public class MediaPlayerImp implements MusicBase {
    MediaPlayer mediaPlayer;
    Context context;
    public MediaPlayerImp(){
        mediaPlayer=new MediaPlayer();
    }
    public MediaPlayerImp(Context context){
        this.context=context;
        mediaPlayer=new MediaPlayer();
    }
    @Override
    public void startMusic() {
        mediaPlayer.start();
    }

    @Override
    public void stopMusic() {
        mediaPlayer.stop();
    }

    @Override
    public void parseMusic() {
        mediaPlayer.pause();
    }

    @Override
    public void initMusic() {
         mediaPlayer = new MediaPlayer();
    }

    @Override
    public void relaseMusic() {
        mediaPlayer.release();
    }

    @Override
    public void setURLAndStart(String name,final boolean isRepeart){
        AssetFileDescriptor descriptor = null;
        try {
            descriptor = context.getAssets().openFd(name);
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
                    descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
            mediaPlayer.prepareAsync();

            // 监听音频播放完的代码，实现音频的自动循环播放
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer arg0) {
                    if (isRepeart) {
                        mediaPlayer.start();
                    }
                    mediaPlayer.setLooping(isRepeart);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
