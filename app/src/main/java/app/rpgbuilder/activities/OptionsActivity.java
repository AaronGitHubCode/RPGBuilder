package app.rpgbuilder.activities;

import app.rpgbuilder.R;
import app.rpgbuilder.adapters.options.OptionsAdapter;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

public final class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_layout);

        final RecyclerView layout = findViewById(R.id.option_adapter);

        layout.setLayoutManager(new GridLayoutManager(this, 2));
        layout.setAdapter(new OptionsAdapter());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
