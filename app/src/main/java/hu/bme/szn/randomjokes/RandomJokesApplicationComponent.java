package hu.bme.szn.randomjokes;
import javax.inject.Singleton;

import dagger.Component;
import hu.bme.szn.randomjokes.network.NetworkModule;
import hu.bme.szn.randomjokes.ui.UIModule;
import hu.bme.szn.randomjokes.interactor.jokes.JokesInteractor;
import hu.bme.szn.randomjokes.ui.jokes.JokeActivity;
import hu.bme.szn.randomjokes.ui.jokes.JokePresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface RandomJokesApplicationComponent {
    void inject(JokeActivity jokeActivity);

    void inject(JokesInteractor jokesInteractor);

    void inject(JokePresenter jokesPresenter);
}

