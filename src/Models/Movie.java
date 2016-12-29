package Models;

/**
 * Created by Ruben on 22/02/15.
 */
public class Movie extends Media {

    private String genre;
    private String collection;
    private String actors;

    public Movie withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Movie withCollection(String collection) {
        this.collection = collection;
        return this;
    }

    public Movie withActors(String actors) {
        this.actors = actors;
        return this;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getCollection() {
        return this.collection;
    }

    public String getActors() {
        return this.actors;
    }
}
