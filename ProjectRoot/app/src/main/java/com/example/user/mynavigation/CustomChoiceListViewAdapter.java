package com.example.user.mynavigation;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomChoiceListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    // this function is mandatory standard nothing useful in our project
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup parent) {
        Context context = parent.getContext();


        if(convertview == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.listview_item, parent, false);
        }

        TextView textView = (TextView)convertview.findViewById(R.id.textView1);
        ListViewItem listViewItem = listViewItemList.get(i);

        textView.setText(listViewItem.getText());

       // CheckBox checkBox = (CheckBox) convertview.findViewById(R.id.checkBox1);

                return convertview;
    }

    public void addItem(String text) {
        ListViewItem item = new ListViewItem();
        item.setText(text);
        Log.d("들어가는 스트링", text);
        listViewItemList.add(item);


    }
    public void RemoveData(int nPosition)
    {
        ListViewItem item = new ListViewItem();
        listViewItemList.remove(nPosition);
    }
}
