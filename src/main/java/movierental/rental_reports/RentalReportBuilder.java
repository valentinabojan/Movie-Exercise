package movierental.rental_reports;
import movierental.movie_rental_entities.Customer;
import movierental.movie_rental_entities.Movie;
import movierental.movie_rental_entities.Rental;
import movierental.rental_visitors.FidelityPointsVisitor;
import movierental.rental_visitors.RentalPriceVisitor;

public class RentalReportBuilder {

    private Customer customer;

    public RentalReportBuilder(Customer customer) {
        this.customer = customer;
    }

    public String buildReport() {
        return buildHeader() + buildBody() + buildFooter();
    }

    private String buildHeader() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String buildBody() {
        String body = "";

        for (Rental rental : customer.getRentals()) {
            double rentalPrice = calculateRentalPrice(rental);
            Movie rentedMovie = rental.getMovie();

            body += buildRentalReportLine(rentedMovie, rentalPrice);
        }

        return body;
    }

    private String buildRentalReportLine(Movie rentedMovie, double rentalPrice) {
        return "\t" + rentedMovie.getTitle() + "\t" + rentalPrice + "\n";
    }

    private String buildFooter() {
        String footer = "";

        footer += "Amount owed is " + getTotalRentalPrice() + "\n";
        footer += "You earned " + getTotalFidelityPoints() + " frequent renter points";

        return footer;
    }

    private double getTotalRentalPrice() {
        return customer.getRentals().stream().map(this::calculateRentalPrice).reduce(0.0, Double::sum);
    }

    private int getTotalFidelityPoints() {
        return customer.getRentals().stream().map(this::calculateRentalFidelityPoints).reduce(0, Integer::sum);
    }

    public double calculateRentalPrice(Rental rental) {
        RentalPriceVisitor visitor = new RentalPriceVisitor();
        rental.accept(visitor);

        return visitor.getRentalPrice();
    }

    public int calculateRentalFidelityPoints(Rental rental) {
            FidelityPointsVisitor visitor = new FidelityPointsVisitor();
            rental.accept(visitor);

            return visitor.getFidelityPoints();
    }
}