package hu.bme.szn.randomjokes.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName;

@Entity
class Joke(

    @SerializedName("setup")
    var setup: String,

    @SerializedName("punchline")
    var punchline: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("id")
    @PrimaryKey
    val id: Long

)
