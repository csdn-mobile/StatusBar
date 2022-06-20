package net.csdn.statusbar.core;

import android.app.Activity;

import net.csdn.statusbar.core.bean.BarColor;
import net.csdn.statusbar.core.bean.BarTransparent;

/**
 * @author kuanggang on 2021/10/14
 */
public interface Helper {

    void changeStatusBar(Activity activity, BarColor color, int fontMode, BarTransparent transparent);

    int addFontMode(int visibility, int fontMode);
}
