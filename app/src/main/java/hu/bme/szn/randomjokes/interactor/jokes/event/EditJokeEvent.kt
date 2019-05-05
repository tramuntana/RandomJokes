package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.Joke

data class EditJokeEvent(
        var code: Int = 3,
        var joke:Joke? = null,
        var throwable: Throwable? = null
)