package movierental;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RentalReportBuilderTest {

    @Test
    public void statementForRegularMovie_ForNormalRental() {
        Movie movie = new Movie("Gone with the Wind", MovieType.REGULAR);
        Rental rental = new Rental(movie, 2); // 2 day rental
        Customer customer =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental)
                        .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForRegularMovie_ForExtendedRental() {
        Movie movie = new Movie("Gone with the Wind", MovieType.REGULAR);
        Rental rental = new Rental(movie, 3); // 3 day rental
        Customer customer =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental)
                        .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie_ForNormalRental() {
        Movie movie = new Movie("Star Wars", MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, 1); // 1 day rental
        Customer customer =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental)
                        .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie_ForExtendedRental() {
        Movie movie = new Movie("Star Wars", MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, 3); // 3 day rental
        Customer customer =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental)
                        .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrenMovie_ForNormalRental() {
        Movie movie = new Movie("Madagascar", MovieType.CHILDREN);
        Rental rental = new Rental(movie, 3); // 3 day rental
        Customer customer
                = new CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental)
                .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrenMovie_ForExtendedRental() {
        Movie movie = new Movie("Madagascar", MovieType.CHILDREN);
        Rental rental = new Rental(movie, 4); // 4 day rental
        Customer customer
                = new CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental)
                .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer);
        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForManyMovies() {
        Movie movie1 = new Movie("Madagascar", MovieType.CHILDREN);
        Rental rental1 = new Rental(movie1, 6); // 6 day rental
        Movie movie2 = new Movie("Star Wars", MovieType.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 2); // 2 day rental
        Movie movie3 = new Movie("Gone with the Wind", MovieType.REGULAR);
        Rental rental3 = new Rental(movie3, 8); // 8 day rental
        Customer customer1
                = new CustomerBuilder()
                .withName("David")
                .withRentals(rental1, rental2, rental3)
                .build();
        RentalReportBuilder reportBuilder = new RentalReportBuilder(customer1);
        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";

        String statement = reportBuilder.buildReport();

        assertEquals(expected, statement);
    }

}
