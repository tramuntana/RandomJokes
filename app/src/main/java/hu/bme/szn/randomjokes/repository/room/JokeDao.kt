package hu.bme.szn.randomjokes.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

import hu.bme.szn.randomjokes.model.MyJoke

@Dao
interface JokeDao {

    @Query("SELECT * FROM myjokes ORDER BY RANDOM() LIMIT 1")
    fun getJoke(): MyJoke

    @Query("SELECT * FROM myjokes WHERE setup = :setup")
    fun findBySetup(setup: String): MyJoke

    @Insert
    fun saveJoke(joke: MyJoke)

    @Query("UPDATE myjokes SET punchline = :punchline WHERE setup = :setup")
    fun updateJoke(setup: String, punchline: String)

    @Query("DELETE FROM myjokes WHERE setup = :setup")
    fun deleteJokeBySetup(setup: String)

    @Query("DELETE FROM myjokes")
    fun deleteAll()

    @Query("SELECT * FROM myjokes")
    fun loadAllJokes(): Array<MyJoke>
}