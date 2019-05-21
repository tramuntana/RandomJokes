package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.MyJoke

data class NewJokeEvent(
        var code: Int = 1,
        var joke:MyJoke? = null,
        var throwable: Throwable? = null
)