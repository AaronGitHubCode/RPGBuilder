package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainMenuFragment constructor(val optionsAdapter: OptionsAdapter) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.options_layout, container, false).let { view ->
            view.findViewById<RecyclerView>(R.id.recyclerView).let { recyclerView ->
                recyclerView.layoutManager = GridLayoutManager(container?.context, 2)
                recyclerView.adapter = optionsAdapter
            }

            view
        }
    }
}