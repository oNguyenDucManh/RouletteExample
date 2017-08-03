package com.manhnd.demo.wheelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.manhnd.demo.AppUtil;

/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public class ItemDrawable extends Drawable {
    private static final String TAG = ItemDrawable.class.getSimpleName();
    private Context mContext;
    private String mTextDescription;
    private Paint mDescriptionPaint;

    private Paint mBackgroundPaint;
    AppUtil appUtil;

    public ItemDrawable(Context context, String text, int color) {

        this.mContext = context;
        this.mTextDescription = text;

        appUtil = AppUtil.getInstance();
        appUtil.initial(context);

        mDescriptionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDescriptionPaint.setColor(Color.WHITE);
        mDescriptionPaint.setTextSize(appUtil.spToPixel(17f));
        mDescriptionPaint.setFakeBoldText(true);
        mDescriptionPaint.setStyle(Paint.Style.FILL);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(color);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setStrokeCap(Paint.Cap.ROUND);

    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawArc(new RectF(bounds.left, bounds.top, bounds.right, bounds.bottom),
                244.5f, 60f, true, mBackgroundPaint);
        canvas.rotate(-90);
        canvas.drawText(mTextDescription, -(bounds.centerY() - 100),
                bounds.centerX() + mDescriptionPaint.descent() * 2, mDescriptionPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mDescriptionPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mDescriptionPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}
