package hu.bme.szn.randomjokes.ui.jokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AlertDialog

import kotlinx.android.synthetic.main.activity_jokes.*

import hu.bme.szn.randomjokes.injector
import hu.bme.szn.randomjokes.R
import hu.bme.szn.randomjokes.ui.about.AboutActivity
import hu.bme.szn.randomjokes.repository.room.MyDatabase
import hu.bme.szn.randomjokes.model.Joke

//Fabric
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

import javax.inject.Inject
import android.widget.Toast


import android.content.DialogInterface
import android.content.Intent


import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import hu.bme.szn.randomjokes.model.MyJoke
import kotlinx.android.synthetic.main.edit_dialog.view.*
import kotlinx.android.synthetic.main.input_dialog.view.*


class JokeActivity : AppCompatActivity(), JokeScreen {

    @Inject
    lateinit var jokePresenter: JokePresenter

    private var joke: Joke = Joke("","","",1000L)
    private var myJoke: MyJoke = MyJoke("","")
    private var database: MyDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_jokes)
        setSupportActionBar(toolbar)
        injector.inject(this)

        database = MyDatabase(this)

        btnGetPunchline.setOnClickListener{ _ ->  punchline.text = joke.punchline}
        btnGetOneMore.setOnClickListener{ _ ->    handleGetOneMore() }
        btnGetMine.setOnClickListener{ _ ->    handleGetMine() }
        newFab.setOnClickListener{ _ ->  showInputDialog() }
        editFab.setOnClickListener{ _ -> showEditDialog()}
        deleteFab.setOnClickListener{ _ -> openDeleteDialog() }

    }

    override fun onStart() {
        super.onStart()
        jokePresenter.attachScreen(this)
        jokePresenter.getRandomJoke()
    }

    override fun onStop() {
        super.onStop()
        jokePresenter.detachScreen()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about_us-> {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    override fun showJokeSetup(randomSetup: String) {
        joke.setup = randomSetup
        setup.text = randomSetup
    }

    override fun showJokePunchline(randomPunchline: String) {
        joke.punchline = randomPunchline

    }

    private fun handleGetOneMore() {
        punchline.text = ""
        jokePresenter.getRandomJoke()

    }

    private fun handleGetMine() {
            myJoke = database!!.jokeDao().getJoke()
            setup.text = myJoke.setup
            punchline.text = myJoke.punchline
    }

    fun openDeleteDialog () {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Joke delete")
        builder.setMessage("Are you sure you want ot delete this joke?")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ -> deleteJoke()})

        builder.setNegativeButton("No", DialogInterface.OnClickListener { _, _ -> Toast.makeText(applicationContext, "You've changed your mind to delete this joke", Toast.LENGTH_SHORT).show() })

        builder.show()
    }

    fun showInputDialog() {

        val view = LayoutInflater.from(this@JokeActivity).inflate(R.layout.input_dialog, null)
        AlertDialog.Builder(this@JokeActivity)
                .setView(view)
                .setPositiveButton("OK") {dialog, i ->
                    var myJoke = MyJoke(view.newsetup.text.toString(), view.newpunchline.text.toString())
                        database!!.jokeDao().saveJoke(myJoke)
                    dialog.dismiss()
                }.show()
}

   fun  showEditDialog() {
       val view = LayoutInflater.from(this@JokeActivity).inflate(R.layout.edit_dialog, null)
       view.editsetup.hint = myJoke.setup
       view.editsetup.isEnabled = false
       view.editpunchline.hint = myJoke.punchline
       AlertDialog.Builder(this@JokeActivity)
               .setView(view)
               .setPositiveButton("OK") {dialog, i ->
                       database!!.jokeDao().updateJoke(setup = myJoke.setup, punchline = view.editpunchline.text.toString())
                   dialog.dismiss()

               }.show()
   }

    fun deleteJoke() {
            database!!.jokeDao().deleteJokeBySetup(myJoke.setup)
        Toast.makeText(applicationContext, "You've choosen to delete this joke", Toast.LENGTH_SHORT).show()
    }



    companion object {
        const val KEY_JOKE = "KEY_JOKE"
    }
}
