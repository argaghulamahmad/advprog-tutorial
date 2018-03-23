import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Customer customer;
    private Movie movie;
    private Movie movie1;
    private Movie movie2;
    private Rental rent;
    private Rental rent1;
    private Rental rent2;

    @Before
    public void setUp() {
        customer = new Customer("Alice");
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rent = new Rental(movie, 3);

        movie1 = new Movie("Zootopia", Movie.CHILDREN);
        movie2 = new Movie("Black Panther", Movie.NEW_RELEASE);
        rent1 = new Rental(movie1, 4);
        rent2 = new Rental(movie2, 3);

    }

    @Test
    public void getName() {
        assertEquals("Alice", customer.getName());
    }

    @Test
    public void statementWithSingleMovie() {
        customer.addRental(rent);

        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("Amount owed is 3.5"));
        assertTrue(result.contains("1 frequent renter points"));
    }

    @Test
    public void statementWithMultipleMovies() {
        customer.addRental(rent1);
        customer.addRental(rent2);
        String result = customer.statement();
        String[] lines = result.split("\n");
        assertEquals(5, lines.length);
        assertTrue(result.contains("Amount owed is 12.0"));
        assertTrue(result.contains("3 frequent renter points"));
    }
}