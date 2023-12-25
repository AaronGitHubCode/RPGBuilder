package app.rpgbuilder.library;

import androidx.annotation.NonNull;

public class Book {
    private boolean unlocked = false;

    private final String title;

    private final Page[] pages;

    public Book(final String title, final Page... pages) {
        this.title = title;
        this.pages = pages;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unlock() {
        unlocked = true;
    }

    public String getTitle() {
        return title;
    }

    public Page getPage(int pageNumber) {
        return pages[pageNumber];
    }

    @NonNull
    @Override
    public String toString() {
        return title.concat(" have ").concat(String.valueOf(pages.length).concat(" pages"));
    }
}
