package movierental.rental_visitors;

import movierental.rental_visitables.ChildrenMovieRental;
import movierental.rental_visitables.NewReleaseMovieRental;
import movierental.rental_visitables.RegularMovieRental;
import movierental.movie_rental_entities.Rental;

public class RentalPriceVisitor implements RentalVisitor {

    private double rentalPrice;

    public double getRentalPrice() {
        return rentalPrice;
    }

    @Override
    public void visit(RegularMovieRental rental) {
        rentalPrice = calculateRentalPrice(rental);
    }

    @Override
    public void visit(NewReleaseMovieRental rental) {
        rentalPrice = calculateRentalPrice(rental);
    }

    @Override
    public void visit(ChildrenMovieRental rental) {
        rentalPrice = calculateRentalPrice(rental);
    }

    private double calculateRentalPrice(Rental rental) {
        rentalPrice = rental.getPriceForNormalRental();

        int extendedRentalDays = rental.getDaysRented() - rental.getDaysForNormalRental();
        if (extendedRentalDays > 0)
            rentalPrice += extendedRentalDays * rental.getPricePerDayForExtendedRental();

        return rentalPrice;
    }
}
