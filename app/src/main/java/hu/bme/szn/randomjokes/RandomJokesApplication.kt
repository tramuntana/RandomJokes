package hu.bme.szn.randomjokes

import android.app.Application

import hu.bme.szn.randomjokes.ui.UIModule

class RandomJokesApplication : Application() {
   lateinit var injector: RandomJokesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRandomJokesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}