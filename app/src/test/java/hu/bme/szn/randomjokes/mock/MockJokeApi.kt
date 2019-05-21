package hu.bme.szn.randomjokes.mock

import hu.bme.szn.randomjokes.model.Joke
import hu.bme.szn.randomjokes.network.JokeApi

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import java.io.IOException
import java.util.*

class MockJokeApi : JokeApi {

    override fun jokeGetOne(): Call<Joke> {

        val joke = Joke("How do locomotives know where they're going?",
                "Lots of training", "general",1000L)

        val call = object : Call<Joke> {
            @Throws(IOException::class)
            override fun execute(): Response<Joke> {
                return Response.success(joke)
            }

            override fun enqueue(callback: Callback<Joke>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Joke> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }


}
