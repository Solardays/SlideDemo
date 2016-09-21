package com.cc.slidedemo.transformer;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * Created by cc on 2016/9/21.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static float MIN_SCALE = 0.75f;

    @SuppressLint("NewApi")
    @Override
    public void transformPage(View view, float position) {

        /**
         *当position < -1，此时position均不代表A页和B页的位置，所以这里我们不做任何的动画出来。
         *当position <= 0，此时position的范围是在0.0 ~-1.0之间，可以认为这是代表A页的运动轨迹，也就是A页移出屏幕外。
         *当position <= 1，此时position的范围是在1.0 ~ 0.0之间，可以认为这是代表B页的运动轨迹，也就是B页移到屏幕上。
         *当position > 1，此时position均不代表A页和B页的位置，所以这里我们不做任何的动画出来。
         */

        int pageWidth = view.getWidth();
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);
        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when
            // moving to the left page
            view.setAlpha(1);
            view.setTranslationX(1);
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);
            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);
            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);

        }
    }
}
