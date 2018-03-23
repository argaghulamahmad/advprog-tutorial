import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import java.util.Objects;

public class MovieTest {

    private Movie movie;
    private Movie movie1;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        movie1 = new Movie("Ant Man", Movie.REGULAR);
    }

    @Test
    public void getTitle() {
        assertEquals("Who Killed Captain Alex?", movie.getTitle());
    }

    @Test
    public void setTitle() {
        movie.setTitle("Bad Black");

        assertEquals("Bad Black", movie.getTitle());
    }

    @Test
    public void getPriceCode() {
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

    @Test
    public void setPriceCode() {
        movie.setPriceCode(Movie.CHILDREN);

        assertEquals(Movie.CHILDREN, movie.getPriceCode());
    }

    @Test
    public void testHashCode() {
        assertEquals(movie.hashCode(), Objects.hash("Who Killed Captain Alex?", Movie.REGULAR));
    }

    @Test
    public void testEquals() {
        assertFalse(movie.equals(null));
        assertTrue(movie1.equals(movie1));
        assertFalse(movie.equals(movie1));
        assertTrue(movie.equals(new Movie("Who Killed Captain Alex?", Movie.REGULAR)));
    }
}