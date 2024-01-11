package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.os.Bundle

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.library_layout, container, false).let {view ->
            view.findViewById<RecyclerView>(R.id.recyclerView2).let { recyclerView ->
                recyclerView.layoutManager = GridLayoutManager(view.context, 1)
                recyclerView.adapter = BooksAdapter(container?.context as Context)
            }

            view
        }
    }
}