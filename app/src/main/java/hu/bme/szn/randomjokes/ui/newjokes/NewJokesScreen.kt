package hu.bme.szn.randomjokes.ui.newjokes

import hu.bme.szn.randomjokes.model.Joke

interface NewJokesScreen {

    fun addNewJoke(joke: Joke)

}