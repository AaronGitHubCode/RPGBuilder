package app.rpgbuilder.adapters.books;

import app.rpgbuilder.R;

public final class Book {

    public static final int BOOK_ICON = R.drawable.book;

    private final String title;
    private final String content;

    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("Title: ".concat(title).concat("\n"));
        builder.append("Content: ".concat(content).concat("\n"));

        return builder.toString();
    }
}
