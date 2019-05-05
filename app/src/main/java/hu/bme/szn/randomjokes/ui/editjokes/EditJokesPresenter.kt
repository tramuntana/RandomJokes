package hu.bme.szn.randomjokes.ui.editjokes

import hu.bme.szn.randomjokes.model.Joke
import hu.bme.szn.randomjokes.ui.Presenter

class EditJokesPresenter : Presenter<EditJokesScreen>() {

    override fun attachScreen(screen: EditJokesScreen) {
        super.attachScreen(screen)
        //TODO
    }

    override fun detachScreen() {
        super.detachScreen()
        //TODO
    }

    fun editJoke(joke: Joke) {
        screen?.editJoke(joke)
    }

}