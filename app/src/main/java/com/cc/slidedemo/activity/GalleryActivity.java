package com.cc.slidedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.cc.slidedemo.R;

public class GalleryActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private ImageSwitcher mSwitcher;
    private Gallery myGallery;

    //图片集合
    private Integer[] Images = { R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.p1, R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        //为他它指定一个ViewFactory，也就是定义它是如何把内容显示出来的，实现ViewFactory接口并覆盖对应的makeView方法。
        mSwitcher.setFactory(this);
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));



        myGallery = (Gallery) findViewById(R.id.myGallery);
        //添加适配器
        myGallery.setAdapter(new BaseAdapter(){

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return View.inflate(GalleryActivity.this,R.layout.item_slide,null);
            }
        });
        //设置监听器
        myGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSwitcher.setImageResource(Images[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setMinimumHeight(200);
        image.setMinimumWidth(200);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setLayoutParams(new ImageSwitcher.LayoutParams(
                ImageSwitcher.LayoutParams.FILL_PARENT, ImageSwitcher.LayoutParams.FILL_PARENT));
        return image;

    }
}
