package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.Joke

data class GetJokeEvent(
        var code: Int = 4,
        var joke:Joke? = null,
        var throwable: Throwable? = null
)