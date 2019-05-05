package hu.bme.szn.randomjokes.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

import hu.bme.szn.randomjokes.ui.jokes.JokePresenter
import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun jokePresenter(executor: Executor, jokeInteractor: JokesInteractor) = JokePresenter(executor, jokeInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

}