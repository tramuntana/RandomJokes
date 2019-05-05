package hu.bme.szn.randomjokes.repository


import android.content.Context
import hu.bme.szn.randomjokes.model.Joke
import javax.inject.Inject

class MemoryRepository @Inject constructor() : Repository {

    companion object {
        var jokes = mutableListOf(
                Joke(
                        setup = "What do ghosts call their true love?",
                        punchline = "Their ghoul-friend",
                        type = "general",
                        id = 1L
                ),
                Joke(
                        setup = "What did the big flower say to the littler flower?",
                        punchline = "Hi, bud!",
                        type = "general",
                        id = 3L
                ),
                Joke(
                        setup = "How do you check if a webpage is HTML5?",
                        punchline = "Try it out on Internet Explorer",
                        type = "programming",
                        id = 2L
                )
        )
    }

    override fun open(context: Context) {
        // Empty
    }

    override fun close() {
        // Empty
    }

    override fun getJoke(): Joke {
        return jokes.get((1..3).shuffled().last())
    }

    override fun saveJoke(joke: Joke) {
        jokes.add(joke)
    }

    override fun updateJoke(joke: Joke) {
        //
    }

    override fun deleteJoke(joke: Joke) {
        jokes.remove(joke)
    }
}