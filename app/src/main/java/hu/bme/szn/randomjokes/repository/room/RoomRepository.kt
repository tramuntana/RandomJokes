package hu.bme.szn.randomjokes.repository.room

import android.arch.persistence.room.Room
import android.content.Context
import javax.inject.Inject

import hu.bme.szn.randomjokes.model.Joke
import hu.bme.szn.randomjokes.repository.Repository

class RoomRepository @Inject constructor() : Repository {

    private lateinit var jokeDao: JokeDao

    override fun open(context: Context) {
        jokeDao = Room.databaseBuilder(context, MyDatabase::class.java, "jokes.db").build().roomDao()
    }

    override fun close() {
        // Empty
    }

    override fun getJoke(): Joke {
        return jokeDao.getJoke((1..3).shuffled().last().toLong())
    }

    override fun saveJoke(joke: Joke) {
        jokeDao.saveJoke(joke)
    }

    override fun updateJoke(joke: Joke) {
        jokeDao.updateJoke(joke)
    }

    override fun deleteJoke(joke: Joke) {
        jokeDao.deleteJoke(joke)
    }

}