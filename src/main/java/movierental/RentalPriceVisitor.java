package movierental;

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
        rentalPrice = rental.getPriceForRegularRental();

        int longRentalDays = rental.getDaysRented() - rental.getDaysForRegularRental();
        if (longRentalDays > 0)
            rentalPrice += longRentalDays * rental.getPricePerDayForLongRental();

        return rentalPrice;
    }
}
