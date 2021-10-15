package com.csdn.statusbar.utils;

import android.content.Context;

public class StatusBarUtils {

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        if (context != null) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }


}
