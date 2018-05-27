package pushimage.notify.com.pushimage.helper;

import android.annotation.TargetApi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;

import pushimage.notify.com.pushimage.R;

/**
 * Created by Dream on 5/15/2018.
 */

public class NotificationHelper extends ContextWrapper {

    public static final String APP_CHANEL = "pushimage.notify.com.pushimage.PushImage";
    public static final String APP_CHANEL_NAME = "PushImage";
    private NotificationManager notificationManager;


    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChanel();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChanel() {
        NotificationChannel channel = new NotificationChannel(APP_CHANEL, APP_CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (notificationManager == null)
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return notificationManager;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getChannel(String title, String body, Bitmap bitmap) {

        Notification.Style style = new Notification.BigPictureStyle().bigPicture(bitmap);

        return new Notification.Builder(getApplicationContext(),APP_CHANEL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("hiii")
                .setAutoCancel(true)
                .setStyle(style);

    }


}
