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

import androidx.appcompat.widget.Toolbar;

import androidx.activity.result.ActivityResultLauncher;

import android.widget.TextView;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {

    private TextView startButton;

    private Toolbar toolbar;

    private final ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new StartActivityForResult(), result -> {
        final Intent intent = result.getData();
    });

    private final ActivityResultLauncher<String[]> permissionsLauncher = registerForActivityResult(new RequestMultiplePermissions(), permissions -> {
        if (permissions.containsValue(false))
            finish();
    });

    public MainActivity() {
        super(R.layout.main_layout);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        startButton = findViewById(R.id.start_button);

        if (checkSelfPermission(POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED)
            permissionsLauncher.launch(new String[]{POST_NOTIFICATIONS});
    }

    @Override
    protected void onStart() {
        super.onStart();

        startService(new Intent(this, AutoSaveService.class));

        startButton.setOnClickListener(view -> {
            activityLauncher.launch(new Intent(this, OptionsActivity.class));
            startButton.setTextColor(Color.RED);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        startButton.setTextColor(Color.WHITE);
    }
}
