package hu.bme.szn.randomjokes.ui.editjokes;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.ui.Presenter;

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
            Long id) {
        screen.editJoke(id);
    }
}