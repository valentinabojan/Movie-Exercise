package rental_reports;

import beans.Customer;
import beans.Movie;
import beans.MovieType;
import beans.Rental;
import rental_strategies.RentalStrategy;
import rental_strategies.RentalStrategyFactory;

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

    private int getTotalFidelityPoints() {
        return customer.getRentals().stream().map(this::calculateFidelityPoints).reduce(0, Integer::sum);
    }

    private double getTotalRentalPrice() {
        return customer.getRentals().stream().map(this::calculateRentalPrice).reduce(0.0, Double::sum);
    }

    private RentalStrategy createRentalStrategy(Rental rental) {
        MovieType movieType = rental.getMovie().getType();

        return RentalStrategyFactory.createStrategy(movieType);
    }

    private double calculateRentalPrice(Rental rental) {
        RentalStrategy strategy = createRentalStrategy(rental);

        return strategy.calculateRentalPrice(rental);
    }

    private int calculateFidelityPoints(Rental rental) {
        RentalStrategy strategy = createRentalStrategy(rental);

        return strategy.calculateFidelityPoints(rental);
    }

}
