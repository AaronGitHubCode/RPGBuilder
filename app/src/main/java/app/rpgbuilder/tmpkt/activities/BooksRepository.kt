package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

internal val BOOK_ICON = R.drawable.book

data class Book constructor(val icon: Int = R.id.book_icon, val title: String, val content: String, val pages: Array<Page>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (icon != other.icon) return false
        if (title != other.title) return false
        if (content != other.content) return false
        return pages.contentEquals(other.pages)
    }

    override fun hashCode(): Int {
        var result = icon
        result = 31 * result + title.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + pages.contentHashCode()
        return result
    }
}

data class Page(internal val pageNumber: Int, internal val pageContent: String)

class BooksRepository {
    companion object {
        @JvmStatic
        private val books: Array<Book> = arrayOf(
            Book(title = "Wizard", content = "For a new wizard's", pages = arrayOf(
                    Page(0, "")
                )
            ),
            Book(title = "Potion lessons", content = "Test", pages = arrayOf(
                    Page(0, "")
                )
            )
        )

        @JvmStatic
        fun size(): Int =  books.size

        @JvmStatic
        fun getBook(position: Int): Book = books[position]
    }
}