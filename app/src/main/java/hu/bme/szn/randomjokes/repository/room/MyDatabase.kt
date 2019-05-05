package hu.bme.szn.randomjokes.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import hu.bme.szn.randomjokes.model.Joke
@Database(
        entities = [Joke::class],
        version = 1,
        exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun roomDao(): JokeDao

}