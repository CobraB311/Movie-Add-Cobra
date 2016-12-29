package Models;

/**
 * Created by Ruben on 22/02/15.
 */
class Media {

    private String title;
    private String mediaType;
    private int year;
    private String quality;
    private String owner;

    public Media withTitle(String title) {
        this.title = title;
        return this;
    }

    public Media withMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public Media withYear(int year) {
        this.year = year;
        return this;
    }

    public Media withQuality(String quality) {
        this.quality = quality;
        return this;
    }

    public Media withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public int getYear() {
        return this.year;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getOwner() {
        return this.owner;
    }
}
