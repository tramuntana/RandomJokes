package hu.bme.szn.randomjokes.interactor.jokes;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.network.JokesApi;
import hu.bme.szn.randomjokes.RandomJokesApplication;

public class JokesInteractor {

    JokesApi jokesApi;

    @Inject
    public JokesInteractor(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
        RandomJokesApplication.injector.inject(this);
    }

    public void getJoke(String query) {
        //TODO
    }

    public void adddNewJoke(String query) {
        //TODO
    }

    public void editJoke(String query) {
        //TODO
    }

    public void deleteJoke(String query) {
        //TODO
    }
}
