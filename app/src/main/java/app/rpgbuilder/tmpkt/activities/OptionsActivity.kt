package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

class OptionsActivity : AppCompatActivity(R.layout.options_layout) {

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        setSupportActionBar(findViewById(R.id.toolbar))

        val mainMenuFragment = MainMenuFragment(OptionsAdapter())

        mainMenuFragment.optionsAdapter.setOnFragmentChange { fragment, tag ->
            supportFragmentManager.beginTransaction().let {
                it.replace(R.id.fragment_container_view, fragment, tag)
                it.commit()
            }
        }

        supportFragmentManager.beginTransaction().let {
            it.add(LibraryFragment(), "library_fragment")
            it.commit()
        }
    }
}