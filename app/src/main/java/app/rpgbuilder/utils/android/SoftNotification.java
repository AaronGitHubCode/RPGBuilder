package app.rpgbuilder.utils.android;

import android.content.Context;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public final class SoftNotification {
    private static final int SOFT_INTEGER_ID = 100;

    private static final String SOFT_STRING_ID = "SOFT_NOTIFICATION_ID";
    private static final String SOFT_STRING_NAME = "SOFT_NOTIFICATION_NAME";

    private SoftNotification() {}

    public static void sendNotification(final Context applicationContext, final String title, final int smallIcon) {
        final var notificationManager = (NotificationManager) applicationContext.getSystemService(Context.NOTIFICATION_SERVICE);
        final var notificationChannel = new NotificationChannel(SOFT_STRING_ID, SOFT_STRING_NAME, NotificationManager.IMPORTANCE_HIGH);
        final var notification = new Notification.Builder(applicationContext, SOFT_STRING_ID).setContentTitle(title).setSmallIcon(smallIcon).build();

        notificationManager.notify(SOFT_INTEGER_ID, notification);
    }
}
