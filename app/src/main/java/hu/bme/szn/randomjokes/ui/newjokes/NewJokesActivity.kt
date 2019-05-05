package hu.bme.szn.randomjokes.ui.newjokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.szn.randomjokes.model.Joke
import javax.inject.Inject

import hu.bme.szn.randomjokes.R

class NewJokesActivity : AppCompatActivity(), NewJokesScreen {

    @Inject
    lateinit var newjokesPresenter: NewJokesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_jokes)

        //TODO

    }

    override fun onStart() {
        super.onStart()
        newjokesPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newjokesPresenter.detachScreen()
    }

    override fun addNewJoke(joke: Joke) {
        //TODO
    }

}