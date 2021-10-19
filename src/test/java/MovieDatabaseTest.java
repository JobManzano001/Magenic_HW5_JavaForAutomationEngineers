
import models.Movie;
import models.MovieDatabase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MovieDatabaseTest {

    /**
     * This test is  for adding movie
     */
    @Test
    public void testAddMovie() {
        MovieDatabase db = new MovieDatabase();
        Movie firstMovie = new Movie(1,"Cat named Bob",500,2,0);
        Movie secondMovie = new Movie(1,"Secret Life of Pets",400,5,20);

        db.addMovie(firstMovie);
        db.addMovie(secondMovie);

        //Verify that firstMovie is added
        Assert.assertTrue(db.getMovieArchive().contains(firstMovie));
        //Verify that secondMovie is added
        Assert.assertTrue(db.getMovieArchive().contains(secondMovie));
    }

    /**
     * This tests are to add and deleting movie
     */
    @Test
    public void testDeleteMovie() {
        MovieDatabase db = new MovieDatabase();
        Movie firstMovie = new Movie(1,"Cat named Bob",500,2,0);
        Movie secondMovie = new Movie(2,"Secret Life of Pets",400,5,20);
        db.addMovie(firstMovie);
        db.deleteMovie(firstMovie);

        //Verify that firstMovie is deleted
        Assert.assertFalse(db.getMovieArchive().contains(firstMovie));
        //Verify that secondMovie is not deleted
        Assert.assertTrue(db.getMovieArchive().contains(secondMovie));
    }

    /**
     * This tests  are to update movie name
     */
    @Test
    public void testUpdateMovieName() {

        MovieDatabase db = new MovieDatabase();
        Movie firstMovie = new Movie(1,"Cat named Bob",500,2,0);

        db.addMovie(firstMovie);
        db.UpdateMovie(firstMovie.getName(), "Bob Cat");

        //Verify firstMovie is updated to new Movie Name
        Assert.assertTrue(db.getMovieArchive().contains(new Movie("Bob Cat")));
    }

    /**
     * This tests are for finding movies
     */
    @Test
    public void testFindingMovies() {
        // Creates the movieDatabase instance and the testing variables
        MovieDatabase db = new MovieDatabase();
        Movie firstMovie = new Movie(1,"Cat named Bob",500,2,0);
        Movie secondMovie = new Movie(2,"Secret Life of Pets",400,5,20);

        // Adds both movies to the database
        db.addMovie(firstMovie);
        db.addMovie(secondMovie);

        // Find movie by ID
        List<Movie> searchedMovie = db.findMovieByID(1);
        Assert.assertTrue(searchedMovie.contains(firstMovie));

        // Find Movie by Name
        searchedMovie = db.findMovieByName("Secret Life of Pets");
        Assert.assertTrue(searchedMovie.contains(secondMovie));
    }
}
