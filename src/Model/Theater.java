package Model;

import java.util.ArrayList;
import java.util.List;

public class Theater extends DataStoreObj {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String website;
    // TODO + 04 mohamed chikani: Create field to hold list of Auditorium
    private List<Auditorium> auditoriums;
    // TODO + 05 mohamed chikani: Create addAuditorium(long) method to update the list
    public void addAuditorium(long auditoriumNumber) {
        auditoriums.add(Datastore.getAuditoriumById(auditoriumNumber));
    }
    public Theater(String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String website) {
        this(null, name, streetAddress, city, state, zipCode, phoneNumber, website);

    }

    public Theater(Long id, String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String website) {
        super(id);
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.auditoriums = new ArrayList<>();

    }
    public String getName() {
        return name;
    }
    public String getZipCode(){
        return zipCode;
    }
    // TODO + 06 mohamed chikani: Create List<Auditorium> getAuditoriums() to return the list
    public List<Auditorium> getAuditoriums() {
        return auditoriums;  // Change this to return the auditoriums
    }

    public String toString() {
        return String.format("%s (%s, %s, %s %s) [%s]", this.name, this.streetAddress, this.city, this.state, this.zipCode, this.phoneNumber);
    }

}
