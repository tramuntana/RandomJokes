package hu.bme.szn.randomjokes.ui.editjokes;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.ui.Presenter;
import hu.bme.szn.randomjokes.model.Joke;

public class EditJokesPresenter extends Presenter<EditJokesScreen> {

    @Inject
    public EditJokesPresenter() {
    }

    @Override
    public void attachScreen(EditJokesScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void editJoke(
            Long id, Joke joke) {
        screen.editJoke(id, joke);
    }
}