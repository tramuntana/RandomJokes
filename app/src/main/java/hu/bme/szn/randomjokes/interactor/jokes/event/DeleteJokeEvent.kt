package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.Joke

data class DeleteJokeEvent(
        var code: Int = 2,
        var joke:Joke? = null,
        var throwable: Throwable? = null
)