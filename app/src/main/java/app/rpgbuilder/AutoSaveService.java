package app.rpgbuilder;

import android.app.Service;

import android.content.Intent;

import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Calendar;

public final class AutoSaveService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(()-> {
            var saveTime = Calendar.getInstance();
            saveTime.set(Calendar.SECOND, saveTime.get(Calendar.MINUTE) + 30);

            for (;;) {
                final var actualDate = Calendar.getInstance();

                if (actualDate.getTime().equals(saveTime.getTime())) {
                    saveTime = Calendar.getInstance();
                    saveTime.set(Calendar.SECOND, saveTime.get(Calendar.MINUTE) + 30);
                    Log.i("saved", "DATA SAVED SUCCESSFULLY!");
                }
            }
        }).start();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
