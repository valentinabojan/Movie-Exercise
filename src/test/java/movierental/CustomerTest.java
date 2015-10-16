package movierental;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.*;

import beans.Customer;
import beans.Movie;
import beans.MovieType;
import beans.Rental;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testCustomer() {
        Customer c = new CustomerBuilder().build();

        assertNotNull(c);
    }

    @Test
    public void testAddRental() {
        Customer customer2 = new CustomerBuilder().withName("Sallie").build();
        Movie movie1 = new Movie("Gone with the Wind", MovieType.REGULAR);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental

        customer2.addRental(rental1);

        assertThat(customer2.getRentals().size()).isEqualTo(1);
    }

    @Test
    public void testGetName() {
        Customer c = new Customer("David");

        assertEquals("David", c.getName());
    }

}