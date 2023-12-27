package app.rpgbuilder.adapters.books;

public final class BooksRepository {

    private BooksRepository() {}

    private static final Book[] books;

    static {
        books = new Book[] {
            new Book("Wizard", "For a new wizard's"),
                new Book("Potion lessons", "Test")
        };
    }

    public static int size() {
        return books.length;
    }

    public static Book getBook(int position) {
        return books[position];
    }
}
