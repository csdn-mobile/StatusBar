package com.csdn.statusbar.core;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.csdn.statusbar.annotation.FontMode;
import com.csdn.statusbar.core.bean.BarColor;

/**
 * @author kuanggang on 2021/10/15
 */
public class HelperImpl implements Helper {

    private HelperImpl() {
    }

    private static class Holder {
        static Helper INSTANCE = new HelperImpl();
    }

    public static Helper getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void changeStatusBar(@NonNull Activity activity, BarColor barColor, int fontMode, boolean isTransparent) {
        Window window = activity.getWindow();

        int visibility = addFontMode(isTransparent ? View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN : View.SYSTEM_UI_FLAG_VISIBLE, fontMode);
        window.getDecorView().setSystemUiVisibility(visibility);

        if (isTransparent || barColor != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(isTransparent ? Color.TRANSPARENT : barColor.color);
        }
    }

    @Override
    public int addFontMode(int visibility, int fontMode) {
        if (fontMode != 0) {
            if (fontMode == FontMode.LIGHT) {
                visibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                visibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
        }
        return visibility;
    }
}
