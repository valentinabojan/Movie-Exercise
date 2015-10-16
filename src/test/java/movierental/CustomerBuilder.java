package movierental;

import movierental.movie_rental_entities.Customer;
import movierental.movie_rental_entities.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBuilder {

    public static final String NAME = "Gregroire";
    private String name = NAME;
    private List<Rental> rentals = new ArrayList<>();

    public Customer build() {
        Customer result = new Customer(name);
        rentals.forEach(result::addRental);
        return result;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withRentals(Rental... rentals) {
        Collections.addAll(this.rentals, rentals);
        return this;
    }

}