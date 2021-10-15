package com.csdn.statusbar;

import android.app.Activity;
import android.content.Context;

import com.csdn.statusbar.annotation.FontMode;
import com.csdn.statusbar.core.Helper;
import com.csdn.statusbar.core.HelperImpl;
import com.csdn.statusbar.core.bean.BarColor;
import com.csdn.statusbar.utils.StatusBarUtils;

/**
 * @author kuanggang on 2021/10/14
 */
public class StatusBar {

    private StatusBar() {
    }

    public static int getHeight(Context context) {
        return StatusBarUtils.getStatusBarHeight(context);
    }

    public static StatusBarBuilder Builder() {
        return new StatusBarBuilder();
    }

    public static class StatusBarBuilder {

        private BarColor mStatusBarColor;
        private int mFontMode = 0;
        private boolean isTransparent = false;

        private StatusBarBuilder() {
        }

        public StatusBarBuilder color(int color) {
            mStatusBarColor = new BarColor(color);
            return this;
        }

        public StatusBarBuilder transparent(boolean isTransparent) {
            this.isTransparent = isTransparent;
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
                helper.changeStatusBar(activity, mStatusBarColor, mFontMode, isTransparent);
            }
        }
    }
}
