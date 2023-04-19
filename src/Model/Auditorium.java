package Model;

import java.util.ArrayList;
import java.util.List;

public class Auditorium extends DataStoreObj {
    // TODO + 01 mohamed chikani: Will have this field auditorium number
    private String auditoriumNumber;
    private List<Showing> showings;

    // TODO + 02 mohamed chikani: set auditorium number via the constructor
    public Auditorium(long auditoriumID, String auditoriumNumber) {
        super(auditoriumID);
        this.auditoriumNumber = auditoriumNumber;
        this.showings = new ArrayList<Showing>();
    }
    public void addShowing(long showingNumber) {
        showings.add(Datastore.getShowingById(showingNumber));
    }

    // TODO + 03 mohamed chikani: toString --> return the auditorum number as a string
    @Override
    public String toString() {
        return String.valueOf(auditoriumNumber);
    }

    public List<Showing> getShowings() {
        return showings;  // Change this to return the showings
    }
}
