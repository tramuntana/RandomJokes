package hu.bme.szn.randomjokes.repository.room

import android.content.Context;

import android.arch.persistence.room.Room
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import hu.bme.szn.randomjokes.model.MyJoke

@Database(entities = arrayOf(MyJoke::class), version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile private var instance: MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                MyDatabase::class.java, "jokes.db")
                .allowMainThreadQueries()
                .build()
    }
}