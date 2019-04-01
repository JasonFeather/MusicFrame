package com.wing.musicframe;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.wing.musicframe.pool.SoudPoolImp;
import com.wing.musicframe.pool.SoundPoolBase;
import com.wing.musicframe.service.MusicSeviceHandle;

/**
 * 姓名：张金齐
 * 日期：2019/3/25
 * 用途功能：音频工具类
 */

public class MusicFactory implements MusicFactoryInterface {

    @Override
    public MusicBase getNormalMusic(FragmentActivity context) {
        return new MediaPlayerHandle(context);
    }

    @Override
    public MusicBase getNormalMusic(Fragment context) {
        return new MediaPlayerHandle(context);
    }

    @Override
    public MusicBase getServieMusic(Context context) {
        return MusicSeviceHandle.getInstance(context);
    }

    @Override
    public SoundPoolBase getSoudPool(Context context) {
        return SoudPoolImp.getInstance(context);
    }
}
