package app.rpgbuilder.activities;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.R;

import android.content.Intent;

import android.graphics.Bitmap;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public final class SceneBuilderActivity extends AppCompatActivity {

    public SceneBuilderActivity() {
        super(R.layout.scene_builder_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final var launcher = registerForActivityResult(new StartActivityForResult(), result -> {
            final var intent = result.getData();
            final var bitmap = (Bitmap) intent.getExtras().get("image");

            if (bitmap != null)
                ((ImageView) findViewById(R.id.image_view_selector)).setImageBitmap(bitmap);
        });

        findViewById(R.id.image_view_selector).setOnClickListener(view -> {
            final var imageView = (ImageView) view;

            launcher.launch(new Intent(Intent.CATEGORY_APP_GALLERY));
        });
    }
}
