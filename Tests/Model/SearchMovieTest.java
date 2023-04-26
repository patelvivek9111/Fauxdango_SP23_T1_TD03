package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchMovieTest {

    @Test
    void SearchMovieTest__pass_String__returns_List_of_Movie_objects() {
        String expected = ((Datastore.searchMoviesByTitle("top")).toString());
        String actual = ("[" + Datastore.getMovieById(1).toString() + "]");

        assertEquals(expected, actual);
    }

}