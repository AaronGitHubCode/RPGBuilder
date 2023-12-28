package app.rpgbuilder.adapters.books;

import app.rpgbuilder.R;

import app.rpgbuilder.library.Page;

public final class Book {

    public static final int BOOK_ICON = R.drawable.book;

    private final String title;
    private final String content;

    private final Page[] pages;

    public Book(String title, String content, Page[] pages) {
        this.title = title;
        this.content = content;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Page getPage(int position) {
        return pages[position];
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("Title: ".concat(title).concat("\n"));
        builder.append("Content: ".concat(content).concat("\n"));

        return builder.toString();
    }
}
