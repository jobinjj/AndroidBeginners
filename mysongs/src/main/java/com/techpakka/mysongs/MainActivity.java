package com.techpakka.mysongs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import jp.co.recruit_lifestyle.android.floatingview.FloatingViewManager;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mpintro;
    private int counter = 0;
    public ArrayList<String> songNames = new ArrayList<>();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFloatinIcon();

       /* if (new PrefManager(MainActivity.this).getBoolean("hidden")){
            findViewById(R.id.player_container).setVisibility(View.GONE);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        File sdCardRoot = Environment.getExternalStorageDirectory();
        File musicFolder = new File(sdCardRoot, "/Music/");
        for (File f : musicFolder.listFiles()) {
            if (f.isFile())
                songNames.add(f.getName());
        }

        //shuffle songs
        Collections.shuffle(songNames);

        mpintro = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/" + songNames.get(counter)));
        if (new PrefManager(this).getBoolean("hidden")){
            findViewById(R.id.player_container).setVisibility(View.GONE);
        }else {
            ImageView imageView = findViewById(R.id.imageView);
            editText = findViewById(R.id.editText);
            ImageView playButton = findViewById(R.id.imageView2);

            AnimatedVectorDrawable animatedVectorDrawable = null;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                animatedVectorDrawable = (AnimatedVectorDrawable) imageView.getDrawable();
           //     animatedVectorDrawable.start();

                final AnimatedVectorDrawable finalAnimatedVectorDrawable = animatedVectorDrawable;
                animatedVectorDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
                    @Override
                    public void onAnimationStart(Drawable drawable) {
                    }

                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        finalAnimatedVectorDrawable.start();
                    }
                });
            }

//        Intent myService = new Intent(MainActivity.this, BacgroundImageService.class);
//        startService(myService);
            mpintro.start();
            mpintro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    counter++;
                    mpintro = MediaPlayer.create(MainActivity.this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/" + songNames.get(counter)));
                    mpintro.start();
                }
            });

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpintro.stop();
                    mpintro = MediaPlayer.create(MainActivity.this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/" + songNames.get(Integer.parseInt(editText.getText().toString()))));
                    mpintro.start();
                }
            });

            findViewById(R.id.root).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new PrefManager(MainActivity.this).putBoolean("hidden",true);
                    mpintro.stop();
                    recreate();
                    return false;
                }
            });
        }*/
    }

    private void setFloatinIcon() {
        final Intent intent = new Intent(this, ChatHeadService.class);
        intent.putExtra(ChatHeadService.EXTRA_CUTOUT_SAFE_AREA, FloatingViewManager.findCutoutSafeArea(this));
        ContextCompat.startForegroundService(this, intent);
    }

    public void playNext(View view) {
        mpintro.stop();
        mpintro = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/" + songNames.get(++counter)));
        mpintro.start();
    }
}
