package app.rpgbuilder.activities;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.R;

import app.rpgbuilder.views.FlickerTextView;

import android.os.Bundle;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {
    private FlickerTextView startButton;

    private final ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new StartActivityForResult(), result -> {
        final Intent intent = result.getData();
    });

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        startButton = findViewById(R.id.start_button);
    }

    @Override
    protected void onStart() {
        super.onStart();

        startButton.setOnClickListener(view -> {
            activityLauncher.launch(new Intent(this, OptionsActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
