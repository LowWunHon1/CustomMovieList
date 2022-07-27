package sg.edu.rp.c346.id21012050.custommovielist;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movie(String title, String genre, int year, String rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
