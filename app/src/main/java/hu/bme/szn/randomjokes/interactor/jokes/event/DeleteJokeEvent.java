package hu.bme.szn.randomjokes.interactor.jokes.event;

public class DeleteJokeEvent {

    private Long id;
    private Throwable throwable;

    public DeleteJokeEvent() {
    }

    public DeleteJokeEvent(Long id, Throwable throwable) {
        this.id = id;
        this.throwable = throwable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
