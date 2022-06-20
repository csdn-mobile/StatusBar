package net.csdn.statusbar;

import android.app.Activity;
import android.content.Context;

import net.csdn.statusbar.annotation.FontMode;
import net.csdn.statusbar.core.Helper;
import net.csdn.statusbar.core.HelperImpl;
import net.csdn.statusbar.core.bean.BarColor;
import net.csdn.statusbar.core.bean.BarTransparent;

/**
 * @author kuanggang on 2021/10/14
 */
public class StatusBar {

    private StatusBar() {
    }

    public static int getHeight(Context context) {
        int result = 0;
        if (context != null) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }

    public static StatusBarBuilder Builder() {
        return new StatusBarBuilder();
    }

    public static class StatusBarBuilder {

        private BarColor mStatusBarColor;
        private BarTransparent mTransparent;
        private int mFontMode = 0;

        private StatusBarBuilder() {
        }

        public StatusBarBuilder color(int color) {
            mStatusBarColor = new BarColor(color);
            return this;
        }

        public StatusBarBuilder transparent(boolean isTransparent) {
            mTransparent = new BarTransparent(isTransparent);
            return this;
        }

        public StatusBarBuilder fontMode(@FontMode int fontMode) {
            this.mFontMode = fontMode;
            return this;
        }

        /**
         * Change statusbar.
         */
        public void change(Activity activity) {
            if (activity != null) {
                Helper helper = HelperImpl.getInstance();
                helper.changeStatusBar(activity, mStatusBarColor, mFontMode, mTransparent);
            }
        }
    }
}
