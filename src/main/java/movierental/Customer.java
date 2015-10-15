package movierental;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }


}