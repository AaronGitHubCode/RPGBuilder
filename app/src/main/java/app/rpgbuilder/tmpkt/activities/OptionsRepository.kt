package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

class OptionsRepository {

    class Option constructor(
        internal val name: String,
        internal val description: String,
        internal val imageResource: Int,
        internal val newer: Boolean = false
    )

    companion object {
        @JvmStatic
        private val options = arrayOf(
            Option("Adventure", "Test", R.drawable.sword),
            Option("Library", "Test", R.drawable.book),
            Option("Jukebox", "Test", R.drawable.sword),
            Option("Options", "Test", R.drawable.book),
            Option("Builder", "Test", R.drawable.book)
        )

        @JvmStatic
        fun size(): Int = options.size

        @JvmStatic
        fun getOption(position: Int): Option = options[position]
    }
}