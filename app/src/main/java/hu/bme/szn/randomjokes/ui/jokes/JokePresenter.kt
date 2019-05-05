package hu.bme.szn.randomjokes.ui.jokes

import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor
import hu.bme.szn.randomjokes.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class JokePresenter  @Inject constructor(private val executor: Executor, private val jokesInteractor: JokesInteractor): Presenter<JokeScreen>() {

    override fun attachScreen(screen: JokeScreen) {
        super.attachScreen(screen)
        //TODO
    }

    override fun detachScreen() {
        super.detachScreen()
        //TODO
    }

    fun  showRandomJokeSetup() {
        screen?.showRandomJokeSetup()
    }

    fun showJokePunchline(id: Long) {
        screen?.showJokePunchline(id)
    }
}