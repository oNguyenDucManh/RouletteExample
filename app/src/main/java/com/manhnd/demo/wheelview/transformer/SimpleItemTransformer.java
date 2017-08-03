package com.manhnd.demo.wheelview.transformer;

import android.graphics.Rect;

import com.manhnd.demo.wheelview.Circle;
import com.manhnd.demo.wheelview.WheelView;


/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public class SimpleItemTransformer implements WheelItemTransformer {
    @Override
    public void transform(WheelView.ItemState itemState, Rect itemBounds) {
        Circle bounds = itemState.getBounds();
        float radius = bounds.getRadius();
        float x = bounds.getCenterX();
        float y = bounds.getCenterY();
        itemBounds.set(Math.round(x - radius), Math.round(y - radius), Math.round(x + radius),
                Math.round(y + radius));
    }
}
