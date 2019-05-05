package hu.bme.szn.randomjokes.repository

import android.content.Context

import hu.bme.szn.randomjokes.model.Joke

interface Repository {

    fun getJoke(): Joke

    fun open(context: Context)

    fun close()

    fun saveJoke(joke: Joke)

    fun updateJoke(joke: Joke)

    fun deleteJoke(joke: Joke)

}