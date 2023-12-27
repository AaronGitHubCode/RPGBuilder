package app.rpgbuilder.adapters.books;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import app.rpgbuilder.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public final class BooksAdapter extends Adapter<BookViewHolder> {
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_section, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.getBookIcon().setImageResource(Book.BOOK_ICON);
        holder.getBookTitleAndContent().setText(BooksRepository.getBook(position).toString());

        holder.getBookView().setOnClickListener(view -> {

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
}