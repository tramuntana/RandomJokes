package hu.bme.szn.randomjokes.ui.jokes;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.ui.Presenter;

public class JokePresenter extends Presenter<JokeScreen> {

    @Inject
    public JokePresenter() {
    }

    @Override
    public void attachScreen(JokeScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showRandomJokeSetup() {
        screen.showRandomJokeSetup();
    }

    public void showJokePunchline(
            Long id) {
        screen.showJokePunchline(id);
    }
}