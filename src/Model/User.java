package Model;

import java.util.Scanner;

public class User extends DataStoreObj {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public User() {
        this(null);
    }

    public User(Long id) {
        super(id);
    }

    public void setFirstName(String firstName) {
        Scanner input = new Scanner(System.in);
        while (!firstName.matches("^[A-Z][a-z]*$")) {
            System.out.println("Invalid input for first name. It must start with a capital letter and have only lowercase letters afterwards.");
            System.out.print("Enter first name: ");
            firstName = input.nextLine();
        }
        this.firstName = firstName;
        System.out.println("\n");
    }

    public void setLastName(String lastName) {
        Scanner input = new Scanner(System.in);
        while (!lastName.matches("^[A-Z][a-z]*$")) {
            System.out.println("Invalid input for last name. It must start with a capital letter and have only lowercase letters afterwards.");
            System.out.print("Enter last name: ");
            lastName = input.nextLine();
        }
        this.lastName = lastName;
        System.out.println("\n");
    }

    public void setEmailAddress(String emailAddress) {
        // Check if email address is valid using a regular expression
        if (!emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.println("Invalid email address format.");
            return;
        }
        this.emailAddress = emailAddress;
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", this.firstName, this.lastName, this.emailAddress);
    }
}

