package com.cc.slidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.slidedemo.R;

/**
 * Created by cc on 2016/9/21.
 */

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_slide, null);
        View view = View.inflate(getActivity(), R.layout.item_slide, null);
        return view;
    }
}
