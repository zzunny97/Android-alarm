package com.example.user.mynavigation;

/**
 * Created by user on 2016-12-26.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// This class is for second fragment which is for setting the alarm time, day, repeat and additional configuration
public class TabFragment2 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_2, container, false);
    }
}
