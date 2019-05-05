package hu.bme.szn.randomjokes.interactor.jokes

import android.util.Log
import hu.bme.szn.randomjokes.interactor.jokes.event.GetJokeEvent
import hu.bme.szn.randomjokes.network.JokeApi
import javax.inject.Inject

class JokesInteractor @Inject constructor(private var jokeApi: JokeApi) {

    fun getJoke(getJokeQuery: String) {
        val event = GetJokeEvent()

        try {

            val artistsQueryCall = jokeApi.jokeGetOne()

            val response = artistsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.joke = response.body() //FIXME
            //EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            //EventBus.getDefault().post(event)
        }
    }
}