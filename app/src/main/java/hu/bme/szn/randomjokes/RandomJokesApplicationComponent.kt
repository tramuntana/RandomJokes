package hu.bme.szn.randomjokes

import dagger.Component
import hu.bme.szn.randomjokes.interactor.InteractorModule
import hu.bme.szn.randomjokes.network.NetworkModule
import hu.bme.szn.randomjokes.ui.UIModule
import hu.bme.szn.randomjokes.ui.about.AboutActivity
import hu.bme.szn.randomjokes.ui.jokes.JokeActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface RandomJokesApplicationComponent {
    fun inject(jokeActivity: JokeActivity)
    fun inject(aboutActivity: AboutActivity)
}