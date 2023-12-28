package app.rpgbuilder.adapters.options;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import static android.view.LayoutInflater.from;

import app.rpgbuilder.R;
import app.rpgbuilder.activities.BattleActivity;
import app.rpgbuilder.activities.LibraryActivity;
import app.rpgbuilder.activities.SceneBuilderActivity;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.ImageButton;

public final class OptionsAdapter extends Adapter<OptionViewHolder> {
    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OptionViewHolder(from(parent.getContext()).inflate(R.layout.option_icon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        final Context context = holder.getOptionButton().getContext();

        holder.getOptionName().setText(OptionsRepository.getOption(position).getName());
        holder.getOptionButton().setImageResource(OptionsRepository.getOption(position).getImgResource());

        holder.getOptionButton().setOnClickListener(view -> {
            switch (OptionsRepository.getOption(position).getName()) {
                case "Adventure" -> context.startActivity(new Intent(context, BattleActivity.class));
                case "Builder" -> context.startActivity(new Intent(context, SceneBuilderActivity.class));
                case "Library" -> context.startActivity(new Intent(context, LibraryActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return OptionsRepository.size();
    }
}

final class OptionViewHolder extends ViewHolder {
    private final ImageButton optionButton;
    private final TextView optionName;

    public OptionViewHolder(final View view) {
        super(view);

        optionButton = view.findViewById(R.id.option_button);
        optionName = view.findViewById(R.id.option_name);
    }

    public ImageButton getOptionButton() {
        return optionButton;
    }

    public TextView getOptionName() {
        return optionName;
    }
}
