package com.manhnd.demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.manhnd.demo.wheelview.ItemDrawable;
import com.manhnd.demo.wheelview.WheelView;
import com.manhnd.demo.wheelview.adapter.WheelArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duc Manh on 01/8/17.
 */


public class MainActivity extends AppCompatActivity {

    private WheelView wheelView;
    private Button btnStart;
    private Runnable mRunnable;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelView = (WheelView) findViewById(R.id.wheel_view);
        btnStart = (Button) findViewById(R.id.btnStart);
        setupData();

    }

    private void setupData() {
        List<String> listStrings = new ArrayList<>();
        listStrings.add("20.000 VND");
        listStrings.add("1 chỉ vàng");
        listStrings.add("1 xe máy SH");
        listStrings.add("50.000 VND");
        listStrings.add("1 Iphone 7");
        listStrings.add("100.000 VND");

        wheelView.setAdapter(new RouletteAdapter(listStrings, this));

        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {

            }
        });
        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                if (!isSelected) {
                    return;
                }
                if (mRunnable == null) {
                    mRunnable = new Runnable() {
                        @Override
                        public void run() {
                            //Xu ly sau khi quay xong
                        }
                    };
                }
                if (mHandler == null) mHandler = new Handler();
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelView.startRoulette(4);
            }
        });

    }

    private static class RouletteAdapter extends WheelArrayAdapter<String> {

        private List<String> list;
        private Context mContext;

        RouletteAdapter(List<String> items, Context context) {
            super(items);
            this.list = items;
            this.mContext = context;
        }

        @Override
        public Drawable getDrawable(int position) {
            int color;
            String text = list.get(position);

            switch (position) {
                case 0:
                    color = mContext.getResources().getColor(R.color.item_roulette_1);
                    break;
                case 1:
                    color = mContext.getResources().getColor(R.color.item_roulette_2);
                    break;
                case 2:
                    color = mContext.getResources().getColor(R.color.item_roulette_3);
                    break;
                case 3:
                    color = mContext.getResources().getColor(R.color.item_roulette_4);
                    break;
                case 4:
                    color = mContext.getResources().getColor(R.color.item_roulette_5);
                    break;
                case 5:
                    color = mContext.getResources().getColor(R.color.item_roulette_6);
                    break;
                case 6:
                    color = mContext.getResources().getColor(R.color.deep_orange_a700);
                    break;
                case 7:
                    color = mContext.getResources().getColor(R.color.green_800);
                    break;
                case 8:
                    color = mContext.getResources().getColor(R.color.cyan_a700);
                    break;
                case 9:
                    color = mContext.getResources().getColor(R.color.light_blue_a700);
                    break;
                case 10:
                    color = mContext.getResources().getColor(R.color.indigo_a700);
                    break;
                default:
                    color = mContext.getResources().getColor(R.color.purple_a700);
                    break;
            }

            return new ItemDrawable(mContext, text, color);
        }
    }
}
