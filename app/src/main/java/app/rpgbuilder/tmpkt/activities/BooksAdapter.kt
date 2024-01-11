package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import app.rpgbuilder.activities.LibraryActivity

import android.content.Intent
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import android.widget.ImageView

import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BooksAdapter constructor(private val context: Context) : Adapter<BooksAdapter.BookViewHolder>() {

    inner class BookViewHolder constructor(view: View) : ViewHolder(view) {
        internal val bookView = view.findViewById<View>(R.id.root_book_view)
        internal val bookIcon = view.findViewById<ImageView>(R.id.book_icon)
        internal val bookTitleAndContent = view.findViewById<TextView>(R.id.book_title_content)

        internal val bookTitle = bookTitleAndContent.text.split("\n")[0]
        internal val bookContent = bookTitleAndContent.text.split("\n")[1]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_section, parent, false))

    override fun getItemCount(): Int =
        BooksRepository.size()

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val appCompat = context as AppCompatActivity

        holder.bookIcon.setImageResource(BOOK_ICON)

        holder.bookTitleAndContent.text = "${BooksRepository.getBook(position).title}\n${BooksRepository.getBook(position).content}"

        holder.bookView.setOnClickListener {
            val intent = Intent(context, LibraryActivity::class.java)

            intent.putExtra("title", holder.bookTitle)
            intent.putExtra("content", holder.bookContent)

            appCompat.registerForActivityResult(StartActivityForResult()) {
            }.launch(Intent(context, MainActivity::class.java))
        }
    }
}