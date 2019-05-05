package hu.bme.szn.randomjokes.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

import hu.bme.szn.randomjokes.model.Joke

@Dao
interface JokeDao {

   // @Query("SELECT * FROM jokes WHERE id = :id")
    fun getJoke(id: Long): Joke

    @Insert
    fun saveJoke(joke: Joke)

    @Update
    fun updateJoke(joke: Joke)

    @Delete
    fun deleteJoke(joke: Joke)


}