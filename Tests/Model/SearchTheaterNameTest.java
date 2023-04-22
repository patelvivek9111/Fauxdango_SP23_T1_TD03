package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTheaterNameTest {

    @Test
    void testToString() {
        String expected = ((Datastore.searchTheatersByName("reg")).toString());
        String actual = ("[" + Datastore.getTheaterById(2).toString() + "]");

        assertEquals(expected, actual);
    }
}