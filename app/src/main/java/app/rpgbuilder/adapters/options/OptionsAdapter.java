package app.rpgbuilder.adapters.options;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import static android.view.LayoutInflater.from;

import app.rpgbuilder.R;

import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

public final class OptionsAdapter extends Adapter<OptionViewHolder> {
    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OptionViewHolder(from(parent.getContext()).inflate(R.layout.option_icon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        holder.getOptionName().setText(OptionsRepository.getOption(position).getName());
        holder.getOptionButton().setImageResource(OptionsRepository.getOption(position).getImgResource());

        holder.getOptionButton().setOnClickListener(view -> {

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
