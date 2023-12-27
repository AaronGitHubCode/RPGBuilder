package app.rpgbuilder.utils.android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import android.graphics.Bitmap;

public class GameNotification {
    private static final int NOTIFICATION_ID = 999;

    private final Context applicationContext;

    private final NotificationManager notificationManager;

    private final NotificationChannel notificationChannel;

    private final String title;
    private final String content;

    private final int smallIcon;

    private final Bitmap bigIcon;

    public static final class GameNotificationBuilder {
        private final Context applicationContext;

        private String title;
        private String content;

        private int smallIcon;

        private Bitmap bigIcon;

        public GameNotificationBuilder(Context applicationContext) {
            this.applicationContext = applicationContext;
        }

        public GameNotificationBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public GameNotificationBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public GameNotificationBuilder setSmallIcon(int smallIcon) {
            this.smallIcon = smallIcon;
            return this;
        }

        public GameNotificationBuilder setBigIcon(Bitmap bigIcon) {
            this.bigIcon = bigIcon;
            return this;
        }

        public GameNotification build() {
            return new GameNotification(applicationContext, title, content, smallIcon, bigIcon);
        }
    }

    private GameNotification(Context applicationContext, String title, String content, int smallIcon, Bitmap bigIcon) {
        this.notificationManager = (NotificationManager) applicationContext.getSystemService(Context.NOTIFICATION_SERVICE);
        this.notificationChannel = new NotificationChannel("RPGBuilder_ID", "RPGBuilder", NotificationManager.IMPORTANCE_HIGH);

        this.applicationContext = applicationContext;
        this.title = title;
        this.content = content;
        this.smallIcon = smallIcon;
        this.bigIcon = bigIcon;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getSmallIcon() {
        return smallIcon;
    }

    public Bitmap getBigIcon() {
        return bigIcon;
    }

    public void sendNotification() {
        final Notification notification = new Notification.Builder(applicationContext, "RPGBuilder_ID")
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(smallIcon)
                .setLargeIcon(bigIcon)
                .build();

        if (notificationManager != null && notificationChannel != null)
            notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
