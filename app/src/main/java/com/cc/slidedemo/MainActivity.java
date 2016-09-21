package com.cc.slidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cc.slidedemo.activity.GalleryActivity;
import com.cc.slidedemo.activity.RecyclerViewActivity;
import com.cc.slidedemo.activity.SlideActivity;
import com.cc.slidedemo.activity.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void j2Slide(View view){
        startActivity(new Intent(this, SlideActivity.class));
    }

    public void j2Gallery(View view){
        startActivity(new Intent(this, GalleryActivity.class));
    }

    public void j2ViewPager(View view){
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void j2RecyclerView(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
