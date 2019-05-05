package hu.bme.szn.randomjokes.ui.newjokes

import hu.bme.szn.randomjokes.model.Joke
import hu.bme.szn.randomjokes.ui.Presenter


class NewJokesPresenter : Presenter<NewJokesScreen>() {

    override fun attachScreen(screen: NewJokesScreen) {
        super.attachScreen(screen)
        //TODO
    }

    override fun detachScreen() {
        super.detachScreen()
        //TODO
    }

    fun addNewJoke(
            joke: Joke) {
        screen?.addNewJoke(joke)
    }

}