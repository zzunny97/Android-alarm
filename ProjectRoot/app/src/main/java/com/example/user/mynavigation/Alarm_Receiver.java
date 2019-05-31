package com.example.user.mynavigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class Alarm_Receiver extends BroadcastReceiver {
    Context context;

    public void onReceive(Context context, Intent intent) {
        this.context = context;

        String input = intent.getExtras().getString("state");

        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.context.startForegroundService(service_intent);
        } else{
            service_intent.putExtra("state", input);
        }
        this.context.startService(service_intent);
    }
}
