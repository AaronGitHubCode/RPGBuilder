package app.rpgbuilder.activities;

import static android.app.Notification.Builder;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.app.NotificationManager;
import android.app.NotificationChannel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.security.Permission;
import java.util.List;

public abstract class NotificationBaseActivity extends AppCompatActivity {
    public static final int APPLICATION_REQUEST_CODE = 100;

    private static final int NOTIFICATION_ID_INT = 100;
    private static final String NOTIFICATION_ID = "NOTIFICATION_ACTIVITY";

    public NotificationBaseActivity(int layout) {
        super(layout);
    }

    protected void sendNotification(String notificationName, String title, String content, int smallIcon, Bitmap largeIcon) {
        final var notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final var notificationChannel = new NotificationChannel(NOTIFICATION_ID, notificationName, NotificationManager.IMPORTANCE_HIGH);
        final var notification = new Builder(this, NOTIFICATION_ID).setContentTitle(title).setContentText(content).setSmallIcon(smallIcon).setLargeIcon(largeIcon).build();

        notificationManager.createNotificationChannel(notificationChannel);

        notificationManager.notify(NOTIFICATION_ID_INT, notification);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == APPLICATION_REQUEST_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            for (final var result : grantResults) {
                if (result == PackageManager.PERMISSION_DENIED)
                    finish();
            }
        }
    }
}
