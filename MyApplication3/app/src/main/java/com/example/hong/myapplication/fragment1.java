package com.example.hong.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hong.myapplication.R;

/**
 * Created by hong on 2017-03-30.
 */

public class fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragview = inflater.inflate(R.layout.fragment1,container,false);
     
        return fragview;
    }
}
