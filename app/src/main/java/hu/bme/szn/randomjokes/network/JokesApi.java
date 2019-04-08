package hu.bme.szn.randomjokes.network;

import hu.bme.szn.randomjokes.model.Joke;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;


public interface JokesApi {
    @GET
    Call<Joke> getJoke();

    @POST
    Call<Joke> addNewJoke(@Body Joke joke);

    @PUT
    Call<Joke> editJoke(@Path("id") int id, @Body Joke joke);

    @DELETE
    Call<Void> deleteJoke(@Path("id") int id);

}
