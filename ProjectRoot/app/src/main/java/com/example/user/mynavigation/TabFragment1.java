package com.example.user.mynavigation;

/**
 * Created by user on 2016-12-26.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


// This class is for first fragment which shows the list of setted alarms
public class TabFragment1 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        ListView listView;
        CustomChoiceListViewAdapter adapter = new CustomChoiceListViewAdapter();

        listView = (ListView)view.findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        adapter.addItem("Vitamin A");
        adapter.addItem("Vitamin B");
        adapter.addItem("Vitamin C");
        adapter.addItem("Vitamin D");

        //adapter.notifyDataSetChanged();

        return view;
    }
}