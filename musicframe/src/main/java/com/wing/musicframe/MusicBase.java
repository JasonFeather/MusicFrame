package com.wing.musicframe;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public interface MusicBase {
    void startMusic();

    void stopMusic();

    void parseMusic();

    void initMusic();

    void relaseMusic();

    void setURLAndStart(String name, boolean isRepeat);

}
