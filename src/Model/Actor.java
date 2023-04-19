package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Actor extends DataStoreObj {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Actor(long id, String firstName,String lastName, LocalDate birthday) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
//    public Actor(String firstName, String lastName, String birthday) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        this.birthday = LocalDate.parse(birthday, formatter);
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthday + ")";
    }
}
