package com.example.user.mynavigation;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// This class is for first fragment which shows the list of setted alarms
public class TabFragment1 extends Fragment{
    CustomChoiceListViewAdapter adapter = new CustomChoiceListViewAdapter();
    //ListView listView = (ListView)getView().findViewById(R.id.listview1);

    ListView listView;


    //listView.setAdapter(adapter);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        listView = (ListView)view.findViewById(R.id.listview1);

        listView.setAdapter(adapter);

//        adapter.addItem("Vitamin A");
//        adapter.addItem("Vitamin B");
//        adapter.addItem("Vitamin C");
//        adapter.addItem("Vitamin D");
//        adapter.addItem("Vitamin E");
        adapter.notifyDataSetChanged();

        Button deleteButton = (Button)view.findViewById(R.id.button) ;
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        adapter.RemoveData(checked) ;

                        // listview 선택 초기화.
                        listView.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;

        return view;


    }



        public void addPlan(String plan, String hour, String minute, boolean[] check_days) {
        // Toast.makeText(getContext(), "add plan 함수 진입", Toast.LENGTH_SHORT);
        // listView.setAdapter(adapter);
        String result = "내용 : "+ plan + " \n" +"시간 :"+  hour + "시 " + minute + "분\n"+"요일 : ";

        if(check_days[0] == true) result += "월";
        if(check_days[1] == true) result += "화";
        if(check_days[2] == true) result += "수";
        if(check_days[3] == true) result += "목";
        if(check_days[4] == true) result += "금";
        if(check_days[5] == true) result += "토";
        if(check_days[6] == true) result += "일";
        if(check_days[7] == true) result += "매일";

        //for(int i=0; i<8; i++) {
        //    if(check_days[i] == true) result += Integer.toString(i);
        //}
        adapter.addItem(result);
        Log.d("resultstring", result);
        adapter.notifyDataSetChanged();
        //listView.setAdapter(adapter);
    }


}
