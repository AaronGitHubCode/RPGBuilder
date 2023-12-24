package app.rpgbuilder.activities;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.R;

import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;

import androidx.appcompat.app.AppCompatActivity;

public final class SceneBuilderActivity extends AppCompatActivity {

    private ImageView backgroundSceneImage;

    private ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new StartActivityForResult(), result -> {
        final var intent = result.getData();
        final var bitmap = (Bitmap) intent.getExtras().get("image");

        backgroundSceneImage.setImageBitmap(bitmap);
    });

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_builder_layout);

        backgroundSceneImage = findViewById(R.id.image_view_selector);
    }

    @Override
    protected void onStart() {
        super.onStart();

        backgroundSceneImage.setOnClickListener(view -> {
            activityLauncher.launch(new Intent(MediaStore.ACTION_PICK_IMAGES));
        });
    }
}
