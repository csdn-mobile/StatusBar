package com.csdn.statusbar.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for font mode.
 *
 * @author kuanggang on 2021/10/15
 */
@IntDef({FontMode.LIGHT, FontMode.DARK})
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface FontMode {
    int LIGHT = 1000;
    int DARK = 1001;
}
