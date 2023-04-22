package Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTheaterZipcodeTest {

    @Test
    void getZipCode__passString__returns_List_of_Theater_objectos() {
        List<String> listOfNameParts = Arrays.asList("19847", "19020");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(Datastore.getTheaterById(1).toString());
        expected.add(Datastore.getTheaterById(2).toString());

        }
    }
