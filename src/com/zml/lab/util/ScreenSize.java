package com.zml.lab.util;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenSize {
    public static float density;
    public static int screenHeight;
    public static int screenWidth;

    public static void getScreenSize(Activity paramActivity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        screenWidth = localDisplayMetrics.widthPixels;
        screenHeight = localDisplayMetrics.heightPixels;
        density = localDisplayMetrics.density;
    }
}
