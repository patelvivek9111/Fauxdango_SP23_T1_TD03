package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends DataStoreObj {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Duration runningTime;
    private Rating rating;
    private List<Genre> genres;
    private List<Actor> actors;

    public Movie(String title, String description, String releaseDate, int runningTimeMinutes, Rating rating) {
        this(null, title, description, releaseDate, runningTimeMinutes, rating, new ArrayList<>());
    }

    public Movie(Long id, String title, String description, String releaseDate, int runningTimeMinutes, Rating rating, List<Genre> genres) {
        super(id);
        this.title = title;
        this.description = description;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.runningTime = Duration.ofMinutes(runningTimeMinutes);
        this.rating = rating;
        this.genres = new ArrayList<>(genres);
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public String getTitle() {
        return title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void addActor(long actorId) {
        Actor actor = Datastore.getActorById(actorId);
        if (actor != null) {
            this.actors.add(actor);
        }
    }

    public List<Actor> getActors() {
        return actors;
    }
    public String toString() {
        int runningTimeMinutes = (int) this.getRunningTime().toMinutes();
        String genresString = String.join(", ", genres.stream().map(Genre::toString).toArray(String[]::new));
        return String.format("%s (%s, %d) [%s] {%d min}", this.title, this.rating, this.releaseDate.getYear(), genresString, runningTimeMinutes);
    }
}
