import models.Movie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieTest {
    /**
     * This test is for the 'Getters'
     */
    @Test
    public void TestMovieGetters() {
        int id = 1;
        String Movie = "Cat Ninja";
        double Price = 50.00;
        int Quantity = 5;
        double Discount = 50;

        Movie movie = new Movie(id,Movie,Price,Quantity,Discount);

        Assert.assertEquals(movie.getMovieID(), id);
        Assert.assertEquals(movie.getName(), Movie);
        Assert.assertEquals(movie.getPrice(), Price);
        Assert.assertEquals(movie.getQuantity(), Quantity);
        Assert.assertEquals(movie.getDiscount(), Discount);
    }

}

