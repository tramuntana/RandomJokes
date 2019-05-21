package hu.bme.szn.randomjokes

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor
import hu.bme.szn.randomjokes.ui.jokes.JokePresenter
import hu.bme.szn.randomjokes.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context


    @Provides
    @Singleton
    fun provideJokePresenter(executor: Executor, jokesInteractor: JokesInteractor) = JokePresenter(executor, jokesInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()

}