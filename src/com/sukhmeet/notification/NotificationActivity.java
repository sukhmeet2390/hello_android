package com.sukhmeet.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.sukhmeet.R;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 11/09/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
    }

    public void createNotification(View view) {
        System.out.println("--------In create Notification--------");
        Intent intent = new Intent(this, NotificationReciever.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        int notificationId = 0;

        Notification notification = new Notification.Builder(this)
                .setContentTitle("New mail form blah blah")
                .setContentText("This is content text")
                .setContentIntent(pendingIntent)  // add pending intent to handle a gesture
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(R.drawable.ic_action_search, "call", pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(notificationId, notification);



    }
}