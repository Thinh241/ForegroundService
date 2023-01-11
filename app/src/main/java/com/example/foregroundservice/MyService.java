package com.example.foregroundservice;

import static com.example.foregroundservice.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataIntent = intent.getStringExtra("data_intent");

        sendNotification(dataIntent);
        return START_NOT_STICKY;//Khong yeu cau chay lai Service
    }

    private void sendNotification(String dataIntent) {

        Intent intent = new Intent(MyService.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
              .setContentTitle("Notification Service")
              .setContentText(dataIntent)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_android_notification).build();

        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
