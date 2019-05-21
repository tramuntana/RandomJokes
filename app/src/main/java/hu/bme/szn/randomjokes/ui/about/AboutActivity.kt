package hu.bme.szn.randomjokes.ui.about

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import hu.bme.szn.randomjokes.R
import hu.bme.szn.randomjokes.injector
import hu.bme.szn.randomjokes.ui.jokes.JokeActivity
import android.view.Menu
import android.view.MenuItem
import android.content.Intent

import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)
        toolbar.setTitle("About")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.about, menu)
        return true
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.jokes -> {
            val intent = Intent(this, JokeActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}
