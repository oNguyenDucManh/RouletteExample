package com.manhnd.demo.wheelview.transformer;

import android.graphics.Rect;

import com.manhnd.demo.wheelview.WheelView;


/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public interface WheelItemTransformer {
    /**
     * You have control over the Items draw bounds. By supplying your own WheelItemTransformer
     * you must call set bounds on the itemBounds.
     */
    void transform(WheelView.ItemState itemState, Rect itemBounds);
}
