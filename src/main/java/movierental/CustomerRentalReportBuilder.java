package movierental;

public class CustomerRentalReportBuilder {

    private Customer customer;

    public CustomerRentalReportBuilder(Customer customer) {
        this.customer = customer;
    }

    public String buildReport() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String report = buildHeader();

        for (Rental rental : customer.getRentals()) {
            double thisAmount = 0;

            MovieType movieType = rental.getMovie().getPriceCode();

            MovieRentalStrategy strategy = MovieRentalStrategyFactory.createStrategy(movieType);

            thisAmount += strategy.calculateRentalPrice(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            report += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        report += buildFooter(totalAmount, frequentRenterPoints);

        return report;
    }

    private String buildFooter(double totalRentalPrice, int frequentRenterPoints) {
        String footer = "";

        footer += "Amount owed is " + totalRentalPrice + "\n";
        footer += "You earned " + frequentRenterPoints + " frequent renter points";

        return footer;
    }

    private String buildHeader() {
        return "Rental Record for " + customer.getName() + "\n";
    }


}
