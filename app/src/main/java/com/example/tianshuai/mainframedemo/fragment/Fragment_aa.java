package com.example.tianshuai.mainframedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tianshuai.mainframedemo.R;

/**
 * Created by tianshuai on 2017/5/2.
 */

public class Fragment_aa  extends Fragment {
    private String context;
    private TextView mTextView;

    public  Fragment_aa(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aa,container,false);
        return view;
    }
}