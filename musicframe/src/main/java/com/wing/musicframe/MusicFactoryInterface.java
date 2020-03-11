package com.wing.musicframe;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.wing.musicframe.pool.SoundPoolBase;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：
 */

public interface MusicFactoryInterface {
    MusicBase getNormalMusic(FragmentActivity context);

    MusicBase getNormalMusic(Fragment context);

    MusicBase getServieMusic(Context context);

    SoundPoolBase getSoudPool(Context context);

}
