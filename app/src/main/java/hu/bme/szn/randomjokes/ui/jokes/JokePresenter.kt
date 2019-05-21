package hu.bme.szn.randomjokes.ui.jokes

import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor
import hu.bme.szn.randomjokes.ui.jokes.JokeScreen
import hu.bme.szn.randomjokes.interactor.jokes.event.GetJokeEvent
import hu.bme.szn.randomjokes.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject
import org.greenrobot.eventbus.EventBus
import hu.bme.szn.randomjokes.model.Joke

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class JokePresenter  @Inject constructor(private val executor: Executor, private val jokesInteractor: JokesInteractor): Presenter<JokeScreen>() {

    override fun attachScreen(screen: JokeScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun  getRandomJoke() {
        executor.execute {
            jokesInteractor.getJoke()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetJokeEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
               // screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.joke != null) {
                    val randomJoke = event.joke
                    screen?.showJokeSetup(randomJoke!!.setup)
                    screen?.showJokePunchline(randomJoke!!.punchline)

                }

            }
        }
    }
}