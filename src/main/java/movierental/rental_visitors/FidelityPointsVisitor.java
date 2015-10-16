package movierental.rental_visitors;

import movierental.rental_visitables.ChildrenMovieRental;
import movierental.rental_visitables.NewReleaseMovieRental;
import movierental.rental_visitables.RegularMovieRental;

public class FidelityPointsVisitor implements RentalVisitor {

    private static final int NEW_RELEASE_MOVIE_MINIMUM_DAYS_FOR_FIDELITY_POINTS = 1;

    private int fidelityPoints;

    public int getFidelityPoints() {
        return fidelityPoints;
    }

    @Override
    public void visit(RegularMovieRental rental) {
        fidelityPoints++;
    }

    @Override
    public void visit(NewReleaseMovieRental rental) {
        fidelityPoints++;

        if (rental.getDaysRented() > NEW_RELEASE_MOVIE_MINIMUM_DAYS_FOR_FIDELITY_POINTS)
            fidelityPoints++;
    }

    @Override
    public void visit(ChildrenMovieRental rental) {
        fidelityPoints++;
    }
}

