package com.example.user.mynavigation;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

// This class is for second fragment which is for setting the alarm time, day, repeat and additional configuration
public class TabFragment2<checked_days> extends Fragment{
    AlarmManager alarmManager;
    TimePicker timePicker;
    PendingIntent pendingIntent;
    Button button_add_alarm;
    Button button_quit_alarm;
    private Context context;
    EditText planET;
    CheckBox mon, tue, wed, thu, fri, sat, sun, every;
    boolean[] checked_days = new boolean[8];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);

        context = container.getContext();

        alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        timePicker = (TimePicker) view.findViewById(R.id.time);
        final Calendar calendar = Calendar.getInstance();
        final Intent receiver_intent = new Intent(this.context, Alarm_Receiver.class);
        button_add_alarm = (Button)view.findViewById(R.id.add);
        button_quit_alarm = (Button)view.findViewById(R.id.quit);
        planET = (EditText)view.findViewById(R.id.planedittext);
        mon = (CheckBox)view.findViewById(R.id.cb_mon);
        tue = (CheckBox)view.findViewById(R.id.cb_tue);
        wed = (CheckBox)view.findViewById(R.id.cb_wed);
        thu = (CheckBox)view.findViewById(R.id.cb_thu);
        fri = (CheckBox)view.findViewById(R.id.cb_fri);
        sat = (CheckBox)view.findViewById(R.id.cb_sat);
        sun = (CheckBox)view.findViewById(R.id.cb_sun);
        every = (CheckBox)view.findViewById(R.id.cb_everyday);

        for(int i=0; i<8; i++) checked_days[i] = false;

        button_add_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                Toast.makeText(context, "Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();

                receiver_intent.putExtra("state", "alarm on");

                pendingIntent = PendingIntent.getBroadcast(context, 0, receiver_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                String planName = planET.getText().toString();

                if(mon.isChecked()) checked_days[0] = true;
                if(tue.isChecked()) checked_days[1] = true;
                if(wed.isChecked()) checked_days[2] = true;
                if(thu.isChecked()) checked_days[3] = true;
                if(fri.isChecked()) checked_days[4] = true;
                if(sat.isChecked()) checked_days[5] = true;
                if(sun.isChecked()) checked_days[6] = true;
                if(every.isChecked()) checked_days[7] = true;

                ((MainActivity)getActivity()).addPlanItem(planName, String.valueOf(hour), String.valueOf(minute), checked_days);
                Toast.makeText(context, "add Plan 완료", Toast.LENGTH_SHORT).show();

            }
        });

        button_quit_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Alarm 종료", Toast.LENGTH_SHORT).show();

                alarmManager.cancel(pendingIntent);
                receiver_intent.putExtra("state", "alarm off");

                context.sendBroadcast(receiver_intent);
            }
        });

        return view;
    }
}
