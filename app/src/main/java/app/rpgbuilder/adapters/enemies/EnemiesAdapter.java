package app.rpgbuilder.adapters.enemies;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import app.rpgbuilder.R;

import app.rpgbuilder.utils.entities.Enemy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public final class EnemiesAdapter extends Adapter<EnemyViewHolder> {
    private final Enemy[] enemies;

    public EnemiesAdapter(Enemy[] enemies) {
        this.enemies = enemies;
    }

    @NonNull
    @Override
    public EnemyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EnemyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.enemy_place, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EnemyViewHolder holder, int position) {

        holder.getEnemyLevel().setText(enemies[position].getFormattedLevel());

        holder.getEnemyView().setOnClickListener(view -> {
            final var enemy = (ImageView) view;


        });
    }

    @Override
    public int getItemCount() {
        return enemies.length;
    }
}

final class EnemyViewHolder extends ViewHolder {

    private TextView enemyLevel;

    private ImageView enemyView;

    public EnemyViewHolder(View view) {
        super(view);

        this.enemyLevel = view.findViewById(R.id.enemy_level);
        this.enemyView = view.findViewById(R.id.enemy_view);
    }

    public TextView getEnemyLevel() {
        return enemyLevel;
    }

    public ImageView getEnemyView() {
        return enemyView;
    }
}