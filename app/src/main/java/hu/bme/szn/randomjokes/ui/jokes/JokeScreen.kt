package hu.bme.szn.randomjokes.ui.jokes

interface JokeScreen {

    fun showJokeSetup(randomSetup: String)

    fun showJokePunchline(randomPunchline: String)

}