package app.rpgbuilder.activities;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import static androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions;
import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.AutoSaveService;
import app.rpgbuilder.R;

import android.content.pm.PackageManager;

import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import android.widget.TextView;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public final class MainActivity extends NotificationBaseActivity {

    public MainActivity() {
        super(R.layout.main_layout);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        final var permissionsLauncher = registerForActivityResult(new RequestMultiplePermissions(), permissions -> {
            if (permissions.containsValue(false))
                finish();
        });
        */

        setSupportActionBar(findViewById(R.id.toolbar));

        if (checkSelfPermission(POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED)
            requestPermissions(new String[] {POST_NOTIFICATIONS}, APPLICATION_REQUEST_CODE);
            //permissionsLauncher.launch(new String[]{POST_NOTIFICATIONS});
    }

    @Override
    protected void onStart() {
        super.onStart();

        final var activityLauncher = registerForActivityResult(new StartActivityForResult(), result -> {
            final Intent intent = result.getData();
        });

        startService(new Intent(this, AutoSaveService.class));

        findViewById(R.id.start_button).setOnClickListener(view -> {
            final TextView self = (TextView) view;

            activityLauncher.launch(new Intent(this, OptionsActivity.class));
            self.setTextColor(Color.RED);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        final TextView startButton = findViewById(R.id.start_button);
        startButton.setTextColor(Color.WHITE);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
