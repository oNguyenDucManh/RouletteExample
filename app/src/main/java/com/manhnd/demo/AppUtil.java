package com.manhnd.demo;

import android.content.Context;
import android.util.TypedValue;


/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public class AppUtil {

    private static AppUtil appUtil;
    private Context context;

    public static AppUtil getInstance() {
        if (appUtil == null) {
            appUtil = new AppUtil();
        }
        return appUtil;
    }

    public void initial(Context context) {
        this.context = context;
    }

    public static int dpToPixel(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public int spToPixel(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }

}
