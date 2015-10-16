package movierental.rental_visitors;

import movierental.rental_visitables.ChildrenMovieRental;
import movierental.rental_visitables.NewReleaseMovieRental;
import movierental.rental_visitables.RegularMovieRental;

public interface RentalVisitor {

    public void visit(RegularMovieRental regularMovieRental);

    public void visit(NewReleaseMovieRental newReleaseMovieRental);

    public void visit(ChildrenMovieRental childrenMovieRental);

}
