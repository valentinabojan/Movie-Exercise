package movierental;

public interface RentalVisitor {

    public void visit(RegularMovieRental regularMovieRental);

    public void visit(NewReleaseMovieRental newReleaseMovieRental);

    public void visit(ChildrenMovieRental childrenMovieRental);

}
