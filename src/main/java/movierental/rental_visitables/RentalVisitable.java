package movierental.rental_visitables;

import movierental.rental_visitors.RentalVisitor;

public interface RentalVisitable {

    public void accept(RentalVisitor rentalVisitor);

}
