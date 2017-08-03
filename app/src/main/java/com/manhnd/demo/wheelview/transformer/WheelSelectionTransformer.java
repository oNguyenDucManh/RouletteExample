package com.manhnd.demo.wheelview.transformer;

import android.graphics.drawable.Drawable;

import com.manhnd.demo.wheelview.WheelView;

/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public interface WheelSelectionTransformer {
    void transform(Drawable drawable, WheelView.ItemState itemState);
}
