package hu.bme.szn.randomjokes.ui.editjokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.szn.randomjokes.model.Joke
import javax.inject.Inject

import hu.bme.szn.randomjokes.R

class EditJokesActivity : AppCompatActivity(), EditJokesScreen {

    @Inject
    lateinit var editjokesPresenter: EditJokesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_jokes)

        //TODO

    }

    override fun onStart() {
        super.onStart()
        editjokesPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        editjokesPresenter.detachScreen()
    }

    override fun editJoke(joke: Joke) {
        //TODO
    }

}