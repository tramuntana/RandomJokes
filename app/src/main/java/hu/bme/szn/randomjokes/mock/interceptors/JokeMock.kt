package hu.bme.szn.randomjokes.mock.interceptors


import android.net.Uri
import okhttp3.Request
import okhttp3.Response
import java.util.Date

import hu.bme.szn.randomjokes.network.NetworkConfig
import hu.bme.szn.randomjokes.model.Joke


object JokeMock {

    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        if (uri.path == NetworkConfig.ENDPOINT_ADDRESS + "Joke" && request.method() == "GET") {
            val joke = Joke("How do locomotives know where they're going?",
                    "Lots of training", "general",1000L)

           // responseString = GsonHelper.gson.toJson(joke)
            responseString = "TODO"
            responseCode = 200
        } else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}