package com.example.weixinfragementdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button button=findViewById(R.id.bt_notification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NotificationActivity.this,Notification2Activity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(NotificationActivity.this,0,intent,0);
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT>26){
                    NotificationChannel channel=new NotificationChannel("channel_1","notification",NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(channel);
                    Notification.Builder notifyBuilder=new Notification.Builder(NotificationActivity.this,"channel_1");
                    notifyBuilder.setContentTitle("微信消息")
                            .setContentText("你有一条微信消息")
                            .setSmallIcon(R.drawable.good)
                            .setWhen(System.currentTimeMillis());

                    notifyBuilder.setContentIntent(pendingIntent);
                    notificationManager.notify(0,notifyBuilder.build());
                }else {
                    Notification.Builder notifyBuilder=new Notification.Builder(NotificationActivity.this);
                    notifyBuilder.setContentTitle("微信消息")
                            .setContentText("你有一条微信消息")
                            .setTicker("你有微信消息！")
                            .setSmallIcon(R.drawable.good)
                            .setWhen(System.currentTimeMillis());

                    notifyBuilder.setContentIntent(pendingIntent);
                    notificationManager.notify(1,notifyBuilder.build());

                }
            }
        });
    }
}
