package hu.bme.szn.randomjokes.ui.jokes

interface JokeScreen {

    fun showRandomJokeSetup()

    fun showJokePunchline(id: Long)

}