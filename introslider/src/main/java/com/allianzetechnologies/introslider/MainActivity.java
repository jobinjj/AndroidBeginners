package com.allianzetechnologies.introslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DotsLayout layoutDots;
    private Button next;
    private Button skip;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        viewPager = findViewById(R.id.view_pager);
        layoutDots = findViewById(R.id.layoutDots);
        next = findViewById(R.id.btn_next);
        skip = findViewById(R.id.btn_skip);

        layouts = new int[]{
           R.layout.screen1,
           R.layout.screen2,
           R.layout.screen3
        };
        layoutDots.setTotalDots(layouts.length);
        layoutDots.setSelectedBottomDots(0);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this,layouts);
        viewPager.setAdapter(myViewPagerAdapter);
        final ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                layoutDots.setSelectedBottomDots(position);
                if (position == layouts.length - 1){
                    next.setText("Start");
                    skip.setVisibility(View.GONE);
                }else {
                    next.setText("Next");
                    skip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem < layouts.length -1){
                    viewPager.setCurrentItem(currentItem + 1);
                }else {
                    launchHomeScreen();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}
