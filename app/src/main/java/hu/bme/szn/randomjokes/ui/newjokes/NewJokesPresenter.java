package hu.bme.szn.randomjokes.ui.newjokes;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.model.Joke;
import hu.bme.szn.randomjokes.ui.Presenter;

public class NewJokesPresenter extends Presenter<NewJokesScreen> {

    @Inject
    public NewJokesPresenter() {
    }

    @Override
    public void attachScreen(NewJokesScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void addNewJoke(
            Joke joke) {
        screen.addNewJoke(joke);
    }
}
