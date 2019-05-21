package hu.bme.szn.randomjokes

import hu.bme.szn.randomjokes.interactor.InteractorModule
import hu.bme.szn.randomjokes.mock.MockNetworkModule
import hu.bme.szn.randomjokes.test.JokeTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : RandomJokesApplicationComponent {
    fun inject(jokeTest: JokeTest)
}