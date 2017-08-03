package com.manhnd.demo.wheelview.adapter;

import java.util.List;

/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public abstract class WheelArrayAdapter<T> implements WheelAdapter {

    private List<T> mItems;

    public WheelArrayAdapter(List<T> items) {
        mItems = items;
    }

    public T getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

}
