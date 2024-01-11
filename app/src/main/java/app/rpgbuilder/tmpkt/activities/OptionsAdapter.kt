package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class OptionsAdapter : Adapter<OptionsAdapter.OptionViewHolder>() {

    private lateinit var onFragmentChangeListener: OnFragmentChangeListener

    inner class OptionViewHolder constructor(view: View) : ViewHolder(view) {
        internal val optionButton = view.findViewById<ImageView>(R.id.option_button)
        internal val optionName = view.findViewById<TextView>(R.id.option_name)
    }

    fun setOnFragmentChangeListener(onFragmentChangeListener: OnFragmentChangeListener): Unit {
        this.onFragmentChangeListener = onFragmentChangeListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder =
        OptionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.option_icon, parent, false))

    override fun getItemCount(): Int =
        OptionsRepository.size()

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionButton.setOnClickListener {
            it as ImageView

            when (position) {
                1 -> {
                    onFragmentChangeListener.onChange(LibraryFragment(), "library_fragment")
                }
            }
        }
    }
}