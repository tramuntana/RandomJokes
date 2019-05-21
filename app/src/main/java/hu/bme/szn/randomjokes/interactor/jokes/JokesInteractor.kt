package hu.bme.szn.randomjokes.interactor.jokes

import android.util.Log
import hu.bme.szn.randomjokes.interactor.jokes.event.*
import hu.bme.szn.randomjokes.network.JokeApi
import javax.inject.Inject
import org.greenrobot.eventbus.EventBus

class JokesInteractor @Inject constructor(private var jokeApi: JokeApi) {

    fun getJoke() {
        val event = GetJokeEvent()

        try {

            val jokeQueryCall = jokeApi.jokeGetOne()

            val response = jokeQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.joke = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

/*
    fun removeJoke(joke: MyJoke) {
        database.jokeDao().deleteJoke(joke)

        val event = DeleteJokeEvent()
        EventBus.getDefault().post(event)
    }

    fun saveJoke(joke: MyJoke) {
        database.jokeDao().saveJoke(joke)

        val event = NewJokeEvent(joke = joke)
        EventBus.getDefault().post(event)
    }*/
}