package app.rpgbuilder.fragments;

import app.rpgbuilder.R;

import app.rpgbuilder.adapters.options.OptionsAdapter;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class MenuFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getView() != null) {
            final var recyclerView = getView().findViewById(R.id.recyclerView);

            ((RecyclerView) recyclerView).setLayoutManager(new GridLayoutManager(getContext(), 1));
            ((RecyclerView) recyclerView).setAdapter(new OptionsAdapter());
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_layout, container, false);
    }
}
