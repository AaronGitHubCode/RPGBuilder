package app.rpgbuilder.activities;

import android.os.Bundle;

import app.rpgbuilder.R;
import app.rpgbuilder.adapters.books.BooksAdapter;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public final class LibraryActivity extends AppCompatActivity {

    public LibraryActivity() {
        super(R.layout.library_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RecyclerView layout = findViewById(R.id.book_adapter);

        layout.setLayoutManager(new GridLayoutManager(this, 1));
        layout.setAdapter(new BooksAdapter());
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
