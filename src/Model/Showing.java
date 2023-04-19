package Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Showing extends DataStoreObj {
    private String movie;
    private LocalTime startTime;

    public Showing(long showingID, String movie, String startTime) {
        super(showingID);
        this.movie = movie;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime, formatter);

    }

    public String getMovie() {
        return movie;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "Movie: " + Datastore.searchMoviesByTitle(movie).get(0).toString() + " {" + startTime
        + "-"+startTime.plus(Datastore.searchMoviesByTitle(movie).get(0).getRunningTime())+"}";
    }
}
