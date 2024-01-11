package app.rpgbuilder.activities;

import app.rpgbuilder.R;
import app.rpgbuilder.adapters.options.OptionsAdapter;
import app.rpgbuilder.fragments.MenuFragment;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

public final class OptionsActivity extends AppCompatActivity {

    public OptionsActivity() {
        super(R.layout.options_layout);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final var recyclerView = findViewById(R.id.recyclerView);

        final var fragmentManager = getSupportFragmentManager();

        final var transaction = fragmentManager.beginTransaction();
        fragmentManager.putFragment(savedInstanceState, "MENU", new MenuFragment());
        transaction.commit();


        if (recyclerView instanceof RecyclerView rv) {
            rv.setLayoutManager(new GridLayoutManager(this, 1));
            rv.setAdapter(new OptionsAdapter());
        } else
            finish();
    }
}
