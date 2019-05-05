package hu.bme.szn.randomjokes

import android.app.Application

class RandomJokesApplication : Application() {
    lateinit var injector: RandomJokesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        //injector = DaggerKotifyDemoApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
