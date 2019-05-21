package hu.bme.szn.randomjokes.test

import hu.bme.szn.randomjokes.testInjector
import hu.bme.szn.randomjokes.ui.jokes.JokePresenter
import hu.bme.szn.randomjokes.ui.jokes.JokeScreen
import hu.bme.szn.randomjokes.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class JokeTest {
    @Inject
    lateinit var jokePresenter: JokePresenter
    private lateinit var jokeScreen: JokeScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        jokeScreen = mock()
        jokePresenter.attachScreen(jokeScreen)
    }

    @Test
    fun test() {
        jokePresenter.getRandomJoke()

        verify(jokeScreen, timeout(5000).atLeastOnce()).showJokePunchline("How do locomotives know where they're going?")
        verify(jokeScreen, timeout(5000).atLeastOnce()).showJokeSetup("Lots of training")

    }

    @After
    fun tearDown() {
        jokePresenter.detachScreen()
    }
}