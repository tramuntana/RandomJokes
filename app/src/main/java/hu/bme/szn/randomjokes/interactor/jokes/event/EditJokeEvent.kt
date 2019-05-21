package hu.bme.szn.randomjokes.interactor.jokes.event

import hu.bme.szn.randomjokes.model.MyJoke

data class EditJokeEvent(
        var code: Int = 2,
        var joke:MyJoke? = null,
        var throwable: Throwable? = null
)