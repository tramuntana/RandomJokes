package hu.bme.szn.randomjokes.interactor.jokes.event;

import hu.bme.szn.randomjokes.model.Joke;

public class EditJokeEvent {

    private Joke joke;
    private Throwable throwable;

    public EditJokeEvent() {
    }

    public EditJokeEvent(Joke joke, Throwable throwable) {
        this.joke = joke;
        this.throwable = throwable;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
