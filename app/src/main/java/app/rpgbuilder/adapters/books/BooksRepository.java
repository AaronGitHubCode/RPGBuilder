package app.rpgbuilder.adapters.books;

import java.util.List;
import java.util.stream.Stream;

import app.rpgbuilder.library.Page;

public final class BooksRepository {

    private BooksRepository() {}

    private static final Book[] books;

    static {
        books = new Book[] {
            new Book("Wizard", "For a new wizard's", new Page[] {}),
                new Book("Potion lessons", "Test", new Page[] {})
        };
    }

    public static int size() {
        return books.length;
    }

    public static Book getBook(int position) {
        return books[position];
    }
}
