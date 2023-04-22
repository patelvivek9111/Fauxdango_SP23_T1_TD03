package Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchActorTest {

    @Test
    void searchActor__passString__returns_List_of_Theater_objects() {
        String expected = ((Datastore.searchActorsByName("tom")).toString());
        String actual = ("[" + Datastore.getActorById(1).toString() + "]");

        assertEquals(expected, actual);
    }
}
