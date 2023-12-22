package app.rpgbuilder.activities;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import static androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions;
import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.AutoSaveService;
import app.rpgbuilder.R;

import app.rpgbuilder.views.FlickerTextView;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {
    private FlickerTextView startButton;

    private final ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new StartActivityForResult(), result -> {
        final Intent intent = result.getData();
    });

    private final ActivityResultLauncher<String[]> permissionsLauncher = registerForActivityResult(new RequestMultiplePermissions(), permissions -> {
        if (permissions.containsValue(false))
            finish();
    });

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

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
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
