package hu.bme.szn.randomjokes.interactor

import dagger.Module
import dagger.Provides

import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor
import hu.bme.szn.randomjokes.network.JokeApi

import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideJokeInteractor(jokeApi: JokeApi) = JokesInteractor(jokeApi)
}
