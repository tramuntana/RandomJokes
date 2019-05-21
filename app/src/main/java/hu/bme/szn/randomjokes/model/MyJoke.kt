package hu.bme.szn.randomjokes.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "myjokes")
class MyJoke (
        @PrimaryKey
        @SerializedName("setup")
        val setup: String,

        @SerializedName("punchline")
        val punchline: String

)