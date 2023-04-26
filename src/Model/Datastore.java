package Model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Datastore {

    private static List<Advertisement> advertisements;
    private static List<Theater> theaters;
    private static List<Movie> movies;
    private static List<Actor> actors;
    private static List<Auditorium> auditoriums;
    private static List<Showing> showings;
    
    public static void clearData() {
        System.out.println("Clearing 'database'");
        advertisements = new ArrayList<>();
        theaters = new ArrayList<>();
        movies = new ArrayList<>();
        actors = new ArrayList<>();
        auditoriums = new ArrayList<Auditorium>();
        showings = new ArrayList<Showing>();
    }

    public static void populateData() {
        System.out.println("Populating 'database'");
        initAdvertisements();
        initActors(); // Call the new method
        initMovies();
        initShowings();
        initAuditoriums();
        initTheaters();

    }

    public static void resetData() {
        clearData();
        populateData();
    }

    static {
        resetData();
    }

    private static void initAuditoriums() {
        System.out.println("Initializing auditoriums");
        Auditorium auditorium;
        auditorium = new Auditorium(1,"auditorium 1");
        auditorium.addShowing(1);
        auditorium.addShowing(2);
        auditoriums.add(auditorium);
        auditorium = new Auditorium(2,"auditorium 2");
        auditorium.addShowing(3);
        auditorium.addShowing(4);
        auditoriums.add(auditorium);
        auditorium = new Auditorium(3,"auditorium 1");
        auditorium.addShowing(5);
        auditorium.addShowing(6);
        auditoriums.add(auditorium);
        auditorium = new Auditorium(4,"auditorium 2");
        auditorium.addShowing(7);
        auditorium.addShowing(8);
        auditoriums.add(auditorium);
    }

    private static void initShowings() {
        System.out.println("Initializing showings");
        showings.add(new Showing(1, "Top Gun", "13:00"));
        showings.add(new Showing(2, "Escape From New York", "16:00"));
        showings.add(new Showing(3, "Halloween", "18:00"));
        showings.add(new Showing(4, "Top Gun", "17:30"));
        showings.add(new Showing(5, "Escape from New York", "19:15"));
        showings.add(new Showing(6, "Spinal tap", "10:00"));
        showings.add(new Showing(7, "Spinal tap", "12:45"));
        showings.add(new Showing(8, "Halloween", "23:00"));
    }


    private static void initTheaters() {
        System.out.println("Initializing theaters");
        Theater theater;

        theater = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
        theater.addAuditorium(1);
        theater.addAuditorium(2);
        theaters.add(theater);

        theater = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com › theatres › regal-ua-oxford-valley");
        theater.addAuditorium(3);
        theater.addAuditorium(4);
        theaters.add(theater);
    }

    private static void initAdvertisements() {
        System.out.println("Initializing advertisements");
        advertisements.add(new Advertisement("Drink Pepsi"));
        advertisements.add(new Advertisement("Buy Candy"));
        advertisements.add(new Advertisement("Shop at Target"));
        advertisements.add(new Advertisement("Watch NCIS"));
    }

    private static void initActors() {
        System.out.println("Initializing actors");

        actors = new ArrayList<>();

        // Actors in Top Gun
        Actor actor1 = new Actor(1L, "Tom", "Cruise",LocalDate.of(1963, 7, 3));
        Actor actor2 = new Actor(2L, "Kelly", "McGillis",LocalDate.of(1957, 7, 9));

        // Actors in Spinal Tap
        Actor actor3 = new Actor(3L, "Michael", "McKean",LocalDate.of(1947, 10, 17));
        Actor actor4 = new Actor(4L, "Christopher", "Guest",LocalDate.of(1948, 2, 5));

        // Actors in Halloween
        Actor actor5 = new Actor(5L, "Jamie", "Lee Curtis",LocalDate.of(1958, 11, 22));
        Actor actor6 = new Actor(6L, "Donald", "Pleasence",LocalDate.of(1919, 10, 5));

        // Actor in Escape from New York
        Actor actor7 = new Actor(7L, "Kurt", "Russell",LocalDate.of(1951, 3, 17));

        // Add actors to list
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);
        actors.add(actor5);
        actors.add(actor6);
        actors.add(actor7);
        //actors.add(actor8);
    }



    private static void initMovies() {
        System.out.println("Initializing movies");

        Movie movie;

        movie = new Movie(1L, "Top Gun", "Fighter pilot Maverick flies a jet.  Goose dies.", "1986-05-16", (1 * 60 + 50), Rating.PG, List.of(Genre.ACTION, Genre.DRAMA));
        movies.add(movie);

        movie = new Movie(2L, "This Is Spinal Tap", "Spinal Tap, is chronicled by film director Marty DiBergi", "1984-03-02", 84, Rating.R, List.of(Genre.COMEDY, Genre.DOCUMENTARY));
        movies.add(movie);

        movie = new Movie(3L, "Halloween", "Michael Meyers kills people", "1978-10-05", 91, Rating.R, List.of(Genre.HORROR));
        movies.add(movie);

        movie = new Movie(4L, "Escape from New York", "Snake Plissken rescues the president", "1981-07-10", 99, Rating.R, List.of(Genre.ACTION));
        movies.add(movie);

    }

    public static List<Advertisement> getAllAdvertisements() {
        return advertisements;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static List<Actor> getActors() {
        return actors;
    }

    public static List<Theater> getTheaters() {
        return theaters;
    }
    public static List<Showing> getShowings() {return showings;}
    public static List<Auditorium> getAuditoriums() {return auditoriums;}

    /**
     * Retrieves a Movie object from the list of movies by its primary key ID.
     *
     * @param id the primary key ID of the Movie to retrieve.
     * @return the Movie object with the given ID, or null if no such Movie is found.
     * @author John Biletz (jkb6036@psu.edu)
     * @author Ildar Sadykov (iqs5261@psu.edu)
     */
    public static Movie getMovieById(long id) {
        for (Movie movie : movies) {
            if (movie.getPrimaryKey() == id) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Retrieves an Actor object from the list of actors by its primary key ID.
     *
     * @param id the primary key ID of the Actor to retrieve.
     * @return the Actor object with the given ID, or null if no such Actor is found.
     * @author John Biletz (jkb6036@psu.edu)
     * @author Ildar Sadykov (iqs5261@psu.edu)
     */
    public static Actor getActorById(long id) {
        for (Actor actor : actors) {
            if (actor.getPrimaryKey() == id) {
                return actor;
            }
        }
        return null;
    }

    public static Auditorium getAuditoriumById(long id) {
        for (Auditorium auditorium: auditoriums) {
            if (auditorium.getPrimaryKey() == id) {
                return auditorium;
            }
        }
        return null;
    }

    public static Theater getTheaterById(long id) {
        for (Theater theater: theaters) {
            if (theater.getPrimaryKey() == id) {
                return theater;
            }
        }
        return null;
    }

    public static Showing getShowingById(long id) {
        for (Showing showing: showings) {
            if (showing.getPrimaryKey() == id) {
                return showing;
            }
        }
        return null;
    }

    public static List<Movie> searchMoviesByTitle(String text) {
        List<Movie> matchedMovie = new ArrayList<>();
        for (Movie movie: movies) {
            String movieTitle = movie.getTitle();
            if (movieTitle.toLowerCase().contains(text.toLowerCase())) {
                matchedMovie.add(movie);
            }
        }
        return matchedMovie;
    }
    public static List<Theater> searchTheatersByName(String text) {
        List<Theater> matchedTheater = new ArrayList<>();
        for (Theater theater: theaters) {
            String theaterName = theater.getName();
            if (theaterName.toLowerCase().contains(text.toLowerCase())) {
                matchedTheater.add(theater);
            }
        }
        return matchedTheater;
    }
    public static List<Theater> searchTheatersByZipcode(String text) {
        List<Theater> matchedTheater = new ArrayList<>();
        for (Theater theater: theaters) {
            String theaterZip = theater.getZipCode();
            if (theaterZip.equals(text) ) {
                matchedTheater.add(theater);
            }
        }
        return matchedTheater;
    }
    public static List<Actor> searchActorsByName(String text) {
        List<Actor> matchedActors = new ArrayList<>();
        for (Actor actor: actors) {
            String actorName = actor.getFirstName()+actor.getLastName();
            if (actorName.toLowerCase().contains(text.toLowerCase())) {
                matchedActors.add(actor);
            }
        }
        return matchedActors;
    }
}
