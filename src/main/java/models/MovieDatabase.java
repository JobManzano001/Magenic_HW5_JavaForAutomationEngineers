package models;

import utils.UserHelperMethods;
import java.util.*;

/**
 * MovieDatabase.java
 */
public class MovieDatabase {
    /**
     *List of every movie in the MovieDatabase class
     */
    private List<Movie> movieArchive;
    /**
     * Creates an instance of the MovieDatabase class
     */
    public MovieDatabase() {
        movieArchive = new ArrayList<Movie>();
    }
    /**
     * Gets the movie archive
     * @return the movie archive
     */
    public List<Movie> getMovieArchive() {
        return movieArchive;
    }
    /**
     * Sets the movie archive
     */
    public void setMovieArchive(List<Movie> movieArchive) {
        this.movieArchive = movieArchive;
    }

    /**
     * Deletes movie from the movie archive
     * @param movieToDelete The movie to be deleted
     */
    public void deleteMovie(Movie movieToDelete) {
        if (movieArchive.contains(movieToDelete)) {
            for (Movie movie : movieArchive) {
                if (movie.equals(movieToDelete)) {
                    movieArchive.remove(movieToDelete);
                    System.out.println("Movie successfully removed");
                    break;
                }
            }
        }
    }
    /**
     * Deletes all the movie from the movie archive
     * @param confirmation The confirmation code to delete the movie
     */
    public void deleteAllMovie(String confirmation){
        if(confirmation.equals("123456789")){
            movieArchive.clear();
            System.out.println("All movies are now removed");
        }
        else{
            System.out.println("Invalid confirmation code");
        }
    }
    /**
     * Update movie from the movie archive
     * @param movieName The movie to be updated
     *@param movieName The new value pf the updated movie
     */
    public void UpdateMovie(String movieName, String newName) {
        int updateCount = 0;
        for (Movie movie : movieArchive) {
            if (movie.getName().equals(movieName)) {
                movie.setName(newName);
                System.out.println("Movie has been successfully updated");
                updateCount+=1;
                break;
            }
        }
        if(updateCount==0) {
            System.out.println("Movie Name not updated");
        }
    }

    /**
     * Add movie from the movie archive. Remove movie once quantity is below 1 stock
     * @param movieName The movie to be updated
     * @param quantity The new value of the updated quantity
     */
    public void updateMovieQuantity(String movieName, int quantity) {
        int updateCount = 0;

        for (Movie movie : movieArchive) {
            if (movie.getName().equals(movieName)) {
                if (quantity > 0) {
                    movie.setQuantity(quantity);
                }
                //remove movie once quantity is 0
                else if (quantity < 1) {
                    movieArchive.remove(movie);
                }
                updateCount += 1;
                break;
            }
        }
        if(updateCount==0) {
            System.out.println("Quantity not updated");
        }
    }
    /**
     * Add movie from the movie archive
     * @param movie The movie to be updated
     *@param movie The new value pf the updated movie
     */
    public void addMovie(Movie movie) {
        if(findMovieByName(movie.getName()).isEmpty())
            if(movie.getQuantity() > 0 ){
                movieArchive.add(movie);
                //System.out.println(newMovie.getName() +  " has been successfully saved");
            }
            else
                System.out.println("Invalid Quantity");
        else
            System.out.println("Movie is existing");
    }
    /**
     * Search movie from the movie archive by movie name
     * @param movieName The movie name to be search
     */
    public List<Movie> findMovieByName(String movieName) {
        List<Movie> filterMovie = new ArrayList<Movie>();

        for (Movie movie : movieArchive) {
            if (movie.getName().equals(movieName)) {
                filterMovie.add(movie);
            }
        }
        return filterMovie;
    }
    /**
     * Search movie from the movie archive by movie id
     * @param id The movie id to be search
     */
    public List<Movie> findMovieByID(int id) {
        List<Movie> searchedMovie = new ArrayList<Movie>();

        for (Movie movie : movieArchive) {
            if (movie.getMovieID() == (id)) {
                searchedMovie.add(movie);
            }
        }
        return searchedMovie;
    }
    //Main method of the class
    public static void main(String[] args) {
        MovieDatabase db = new MovieDatabase();

        db.addMovie(new Movie(1,"Movie 1", 100.00, 3,10));
        db.addMovie(new Movie(2,"Movie 1", 400.00, 5,5));
        db.UpdateMovie("Movie 2", "TEST 3");
        db.UpdateMovie("Movie 3", "TEST 2");

        UserHelperMethods.printMovie(db.movieArchive);

        System.out.println(db.getMovieArchive().size());
        System.out.println(db.movieArchive.contains(new Movie("TEST 1")));
        db.deleteMovie(new Movie("TEST 1"));
        System.out.println(db.movieArchive.contains(new Movie("TEST 1")));
    }
}