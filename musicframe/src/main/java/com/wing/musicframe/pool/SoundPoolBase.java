package com.wing.musicframe.pool;

import java.util.ArrayList;

/**
 * 姓名：张金齐
 * 日期：2019/3/26
 * 用途功能：
 */

public interface SoundPoolBase {
    void load(ArrayList<String> list);

    void stop(String name);
    void stop(int id);

    void pause(String name);

    void resume(String name);

    void release();

    void setLoop(String name, int loop);

    void setPriority(String name, int priority);

    void setRate(String name, float rate);

    void setVolume(String name, float leftVolume, float rightVolume);

    int playSound(String name, int number);

    void stopAll();
}
