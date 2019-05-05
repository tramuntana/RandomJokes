package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.Joke

data class AddNewJokeEvent(
        var code: Int = 0,
        var joke:Joke? = null,
        var throwable: Throwable? = null
)