package Models;

/**
 * Created by Ruben on 22/02/15.
 */
public class Serie extends Media {

    private int season;
    private int episodes;

    public Serie withSeason(int season) {
        this.season = season;
        return this;
    }

    public Serie withEpisodes(int episodes) {
        this.episodes = episodes;
        return this;
    }

    public int getSeason() {
        return this.season;
    }

    public int getEpisodes() {
        return this.episodes;
    }
}
