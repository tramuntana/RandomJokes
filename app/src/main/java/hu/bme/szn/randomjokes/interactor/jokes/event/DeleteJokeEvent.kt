package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.MyJoke

data class DeleteJokeEvent(
        var code: Int = 3,
        var throwable: Throwable? = null
)