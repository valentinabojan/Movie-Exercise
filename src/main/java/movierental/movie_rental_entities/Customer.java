package movierental.movie_rental_entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(rentals);
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }
}