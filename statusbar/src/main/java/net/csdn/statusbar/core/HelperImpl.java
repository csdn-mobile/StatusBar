package net.csdn.statusbar.core;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import net.csdn.statusbar.annotation.FontMode;
import net.csdn.statusbar.core.bean.BarColor;
import net.csdn.statusbar.core.bean.BarTransparent;

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
    public void changeStatusBar(@NonNull Activity activity, BarColor barColor, int fontMode, BarTransparent transparent) {
        Window window = activity.getWindow();

        int visibility = window.getDecorView().getSystemUiVisibility();
        if (transparent == null) {
            if (fontMode != 0) {
                // need set font
                if (visibility == View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        || visibility == (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
                        || visibility == (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)) {
                    visibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                } else {
                    visibility = View.SYSTEM_UI_FLAG_VISIBLE;
                }
                visibility = addFontMode(visibility, fontMode);
            }
        } else {
            if (fontMode != 0) {
                // need set font
                visibility = transparent.isTransparent ? View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN : View.SYSTEM_UI_FLAG_VISIBLE;
                visibility = addFontMode(visibility, fontMode);
            } else {
                // only change transparent
                if (visibility == (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                        || visibility == (View.SYSTEM_UI_FLAG_VISIBLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)) {
                    // light font
                    visibility = (transparent.isTransparent ? View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN : View.SYSTEM_UI_FLAG_VISIBLE)
                            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                } else {
                    // dark font
                    visibility = (transparent.isTransparent ? View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN : View.SYSTEM_UI_FLAG_VISIBLE)
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                }
            }
        }
        window.getDecorView().setSystemUiVisibility(visibility);

        if (transparent != null && transparent.isTransparent || barColor != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(transparent != null && transparent.isTransparent ? Color.TRANSPARENT : barColor.color);
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
