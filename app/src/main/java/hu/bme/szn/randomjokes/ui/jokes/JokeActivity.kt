package hu.bme.szn.randomjokes.ui.jokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_jokes.*

import hu.bme.szn.randomjokes.injector
import hu.bme.szn.randomjokes.R


import javax.inject.Inject

class JokeActivity : AppCompatActivity(), JokeScreen {

    @Inject
    lateinit var jokePresenter: JokePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)
        injector.inject(this)

        //TODO

    }

    override fun onStart() {
        super.onStart()
        jokePresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        jokePresenter.detachScreen()
    }

    override fun showRandomJokeSetup() {
        //TODO
    }

    override fun showJokePunchline(id: Long) {
        //TODO
    }

    companion object {
        const val KEY_JOKE = "KEY_JOKE"
    }
}
