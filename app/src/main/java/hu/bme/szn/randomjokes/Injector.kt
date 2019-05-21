package hu.bme.szn.randomjokes

import android.app.Activity
import android.support.v4.app.Fragment


val Activity.injector: RandomJokesApplicationComponent
    get() {
        return (this.applicationContext as RandomJokesApplication).injector
    }

