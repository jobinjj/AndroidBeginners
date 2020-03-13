package com.allianzetechnologies.introslider;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DotsLayout extends LinearLayout {
    private int totalDots;

    public DotsLayout(Context context) {
        super(context);
        init();
    }

    public DotsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotsLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    public void setSelectedBottomDots(int page){
        TextView[] dots = new TextView[totalDots];

        removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorInActive));
            addView(dots[i]);
        }

        if (dots.length > 0){
            dots[page].setTextColor(getResources().getColor(R.color.colorActive));
        }
    }

    public void setTotalDots(int totalDots){
        this.totalDots = totalDots;
    }
}
