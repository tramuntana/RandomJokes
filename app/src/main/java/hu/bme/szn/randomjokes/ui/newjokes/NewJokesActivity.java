package hu.bme.szn.randomjokes.ui.newjokes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import hu.bme.szn.randomjokes.R;
import hu.bme.szn.randomjokes.model.Joke;


public class NewJokesActivity extends AppCompatActivity implements NewJokesScreen {

    @Inject
    NewJokesPresenter newJokesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //TODO

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_jokes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        newJokesPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        newJokesPresenter.detachScreen();
    }


    @Override
    public void addNewJoke(Joke joke) {

        //TODO
    }

}
