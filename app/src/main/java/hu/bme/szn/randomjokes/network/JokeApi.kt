package hu.bme.szn.randomjokes.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path

import hu.bme.szn.randomjokes.model.Joke

import okhttp3.ResponseBody

import java.math.BigDecimal

interface JokeApi {
    /**
     * Get a random Joke instance from the data source.
     *
     * @return Call<Joke>
     */

    @GET(".")
    fun jokeGetOne(): Call<Joke>

    /**
     * Update attributes for a joke instance and persist it into the data source.
     *
     * @param id PersistedJoke id
     * @param data An object of model property name/value pairs
     * @return Call<Joke>
     */
/*
    @PUT("Jokes")
    fun jokeUpdate(
    @Path("id") id: BigDecimal, @Body data: Joke): Call<Joke>


    /**
     * Create a new instance of a joke and persist it into the data source.
     *
     * @param data Joke instance data
     * @return Call<Joke>
     */

    @POST("Jokes")
    fun jokeCreate(@Body data:Joke):  Call<Joke>


    /**
     * Delete a joke instance by id from the data source.
     *
     * @param id Joke id
     * @return Call<InlineResponse200>
     */

    @DELETE("Jokes")
    fun jokeDeleteById(@Path("id") id: BigDecimal): Call<ResponseBody>*/
}