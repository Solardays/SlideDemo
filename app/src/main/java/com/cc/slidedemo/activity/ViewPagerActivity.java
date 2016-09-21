package com.cc.slidedemo.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cc.slidedemo.R;
import com.cc.slidedemo.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager vp;

    private int[] mImgIds = new int[] { R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.p1, R.mipmap.ic_launcher,R.mipmap.p1, };
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_view_pager);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setPageMargin(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));

        vp.setOffscreenPageLimit(3);
        // 3.将父类的touch事件分发至viewPgaer，否则只能滑动中间的一个view对象
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return vp.dispatchTouchEvent(event);
            }
        });

        initData();
        vp.setAdapter(new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {

                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object)
            {

                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public int getCount()
            {
                return mImgIds.length;
            }
        });

        vp.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    private void initData()
    {
        for (int imgId : mImgIds)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }
}
