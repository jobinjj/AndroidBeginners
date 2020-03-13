package com.allianzetechnologies.glidecaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        Glide.with(this).load("https://fsb.zobj.net/crop.php?r=fFhKrBLCoaSTDFvYjNxm8AzgUjmqE2RCuGNItMLcPq5WkgrE9tk5IpkD9rPJ8qbk9bSDClAwvTiXPig720416PUvIRJE38uJ4_WJoTgSxat0aJoPF2FpwQYHIihXWXePp4F1vfCQP5DSCF66Nf8M-2GNkxoTuom4-tNzQzQnBrRDpLzvAf_VbHagTW4").diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }
}
