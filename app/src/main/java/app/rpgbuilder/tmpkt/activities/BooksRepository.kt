package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

internal val BOOK_ICON = R.drawable.book

data class Book constructor(val icon: Int = R.id.book_icon, val title: String, val content: String, val pages: Array<Page>)
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