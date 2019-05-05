package hu.bme.szn.randomjokes.model


import com.google.gson.annotations.SerializedName;

class Joke(

    @SerializedName("setup")
    val setup: String,

    @SerializedName("punchline")
    val punchline: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("id")
    val id: Long
)
