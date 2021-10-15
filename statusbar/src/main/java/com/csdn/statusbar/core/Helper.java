package com.csdn.statusbar.core;

import android.app.Activity;

import com.csdn.statusbar.core.bean.BarColor;

/**
 * @author kuanggang on 2021/10/14
 */
public interface Helper {

    void changeStatusBar(Activity activity, BarColor color, int fontMode, boolean isTransparent);

    int addFontMode(int visibility, int fontMode);
}
