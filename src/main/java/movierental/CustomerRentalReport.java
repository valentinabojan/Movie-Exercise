package movierental;
import java.util.ArrayList;
import java.util.List;

public class CustomerRentalReport {

    private String name;
    private List<Rental> rentals;

    public CustomerRentalReport(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String buildCustomerRentalsReport() {
        String report = buildHeader();

        double totalRentalPrice = 0;
        int fidelityPoints = 0;
        for (Rental rental: rentals) {
            double rentalPrice = calculateRentalPrice(rental);

            totalRentalPrice += rentalPrice;
            fidelityPoints += calculateRentalFidelityPoints(rental);

            report += buildRentalReportLine(rental.getMovie(), rentalPrice);
        }

        report += buildFooter(totalRentalPrice, fidelityPoints);

        return report;
    }

    public String buildHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    public String buildRentalReportLine(Movie movie, double rentalPrice) {
        return "\t" + movie.getTitle() + "\t" + rentalPrice + "\n";
    }

    public String buildFooter(double totalRentalPrince, int frequentRenterPoints) {
        String footer = "";

        footer += "Amount owed is " + totalRentalPrince + "\n";
        footer += "You earned " + frequentRenterPoints + " frequent renter points";

        return footer;
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