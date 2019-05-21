package hu.bme.szn.randomjokes.test

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment;

import hu.bme.szn.randomjokes.model.MyJoke
import hu.bme.szn.randomjokes.repository.room.JokeDao
import hu.bme.szn.randomjokes.repository.room.MyDatabase
import java.io.IOException

import android.arch.persistence.room.Room

@RunWith(RobolectricTestRunner::class)
class DatabaseTest {
    private lateinit var jokeDao: JokeDao
    private lateinit var db: MyDatabase

    @Before
    fun createDb() {
        val context = RuntimeEnvironment.application.applicationContext
        db = Room.inMemoryDatabaseBuilder(
                context, MyDatabase::class.java).build()
        jokeDao = db.jokeDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun saveAndFindTest() {
        val myJoke =  MyJoke("testSetup", "testPunchline")
        jokeDao.saveJoke(myJoke)
        val savedJoke= jokeDao.findBySetup("testSetup")
        assertEquals(savedJoke, myJoke)
    }


    @Test
    @Throws(Exception::class)
    fun loadAllTest() {
        val myJoke1=  MyJoke("testSetup1", "testPunchline1")
        jokeDao.saveJoke(myJoke1)
        val myJoke2 =  MyJoke("testSetup2", "testPunchline2")
        jokeDao.saveJoke(myJoke2)
        val myJoke3 =  MyJoke("testSetup3", "testPunchline3")
        jokeDao.saveJoke(myJoke3)
        assertEquals(jokeDao.loadAllJokes().size,2)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllTest() {
        val myJoke1=  MyJoke("testSetup1", "testPunchline1")
        jokeDao.saveJoke(myJoke1)
        val myJoke2 =  MyJoke("testSetup2", "testPunchline2")
        jokeDao.saveJoke(myJoke2)
        assertEquals(jokeDao.loadAllJokes().size,2)
        jokeDao.deleteAll()
        assertEquals(jokeDao.loadAllJokes().size,0)

    }
}