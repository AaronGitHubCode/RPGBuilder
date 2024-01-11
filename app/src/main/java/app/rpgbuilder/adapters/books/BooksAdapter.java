package app.rpgbuilder.adapters.books;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import app.rpgbuilder.R;

import app.rpgbuilder.activities.BookActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.content.Intent;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public final class BooksAdapter extends Adapter<BookViewHolder> {

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_section, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Context context = holder.getBookIcon().getContext();

        final var appcompat = (AppCompatActivity) context;
        final var launcher = appcompat.registerForActivityResult(new StartActivityForResult(), data -> {
            final Intent intent = data.getData();
        });

        holder.getBookIcon().setImageResource(Book.BOOK_ICON);
        holder.getBookTitleAndContent().setText(BooksRepository.getBook(position).toString());

        holder.getBookView().setOnClickListener(view -> {
            final Intent intent = new Intent(context, BookActivity.class);

            intent.putExtra("title", holder.getBookTitle());
            intent.putExtra("content", holder.getBookContent());

            launcher.launch(new Intent(context, BookActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return BooksRepository.size();
    }
}

final class BookViewHolder extends ViewHolder {

    private final View bookView;

    private final ImageView bookIcon;

    private final TextView bookTitleAndContent;

    public BookViewHolder(View bookView) {
        super(bookView);

        this.bookView = bookView.findViewById(R.id.root_book_view);
        this.bookIcon = bookView.findViewById(R.id.book_icon);
        this.bookTitleAndContent = bookView.findViewById(R.id.book_title_content);
    }

    public View getBookView() {
        return bookView;
    }

    public ImageView getBookIcon() {
        return bookIcon;
    }

    public TextView getBookTitleAndContent() {
        return bookTitleAndContent;
    }

    public String getBookTitle() {
        return bookTitleAndContent.getText().toString().split("\n")[0];
    }

    public String getBookContent() {
        return bookTitleAndContent.getText().toString().split("\n")[1];
    }
}