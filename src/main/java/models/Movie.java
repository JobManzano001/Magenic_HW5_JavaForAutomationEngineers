package models;

public class Movie implements Comparable<Movie> {
    /**
     * The id of the movie
     */
    private int movieID;
    /**
     * The name of the movie
     */
    private String name;
    /**
     * The price of the movie
     */
    private double price;
    /**
     * The quantity of the movie
     */
    private int quantity;
    /**
     * The discount of the movie
     */
    private double discount;

    /**
     * Creates an instance of the Song class
     * @param movieID The movie id
     * @param name The name of movie
     * @param price The price of movie
     * @param quantity The quantity of movie
     * @param discount The discount of movie
     */
    public Movie(int movieID,String name, double price, int quantity, double discount) {
        this.movieID = movieID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
    /**
     * Creates an instance of the Song class
     * @param movieID The movie id
     */
    public Movie(int movieID){
        this.movieID = movieID;
    }
    /**
     * @param name The name of movie
     */
    public Movie(String name) {
        this.name = name;
    }
    /**
     * Creates an instance of the Song class
     * @param name The movie id
     * @param name The price of movie
     */
    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
     * Creates an instance of the Song class
     * @param name The movie id
     * @param quantity The quanity of movie
     */
    public Movie(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    /**
     * Gets the movie id
     * @return The movie id
     */
    public int getMovieID() {
        return movieID;
    }
    /**
     * Sets the movie ID if it is not null or whitespace
     * @param movieID The movie id
     */
    public void setMovieID(int movieID){
        this.movieID = movieID;
    }
    /**
     * Gets the movie name
     * @return The movie name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the movie name if it is not null or whitespace
     * @param name The movie id
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the movie price
     * @return The price name
     */
    public double getPrice() {
        return price;
    }
    /**
     * Sets the movie price
     * @param price The movie id
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Gets the movie quantity
     * @return The quantity of movie
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets the movie quantity
     * @param quantity The movie id
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * Gets the movie quantity
     * @return The discount of movie
     */
    public double getDiscount(){
        return discount;
    }
    /**
     * Sets the movie discount
     * @param discount The movie id
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }
    /**
     * Determines if this models.Song obj is equal to the provided object
     * @param obj The compared object
     * @return True if the Songs are the same, and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !Movie.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Movie otherMovie = (Movie) obj;

        return this.getName().equals(otherMovie.getName());
    }
    /**
     * Converters a models.Movie to a string description
     * @return The string representation of a 'models.Movie' object
     */
    @Override
    public String toString() {
        return "ID:" + getMovieID() +  "|TITLE: " + getName() +  " | QUANTITY: " + getQuantity() + " | PRICE: " + getPrice() +" | DISCOUNT: " + getDiscount();
    }
    /**
     * IMPORTANT NOTE: THIS METHOD IS NEEDED FOR SIMPLICITY IN THE HOMEWORK, BUT IT IS NOT BEGINNER FRIENDLY YOU DO NOT NEED TO TOUCH THIS METHOD
     *                 For anyone who wants to learn more about compareTo read this link, but you have been warned: https://medium.com/omarelgabrys-blog/comparing-objects-307400115f88
     * @param otherMovie The other movie object
     * @return 0 if the movie are equal and other numbers if not
     */
    @Override
    public int compareTo(Movie otherMovie) {
        if (this.getName().compareTo(otherMovie.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(otherMovie.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    //main method of the class
    public static void main(String[] args) {
        Movie movieOne = new Movie(1,"MovieOne", 100.00, 1,10);
        Movie movieTwo = new Movie(2,"MovieTwo", 200.00, 4,5);
        Movie dupe = new Movie(3,"MovieOne", 100.00, 8,20);

        movieOne.compareTo(movieTwo);
        movieOne.compareTo(dupe);

        System.out.println(movieOne);
        System.out.println(movieTwo);

        System.out.println("Movie are equal: " + movieOne.equals(movieTwo));

        movieTwo.setName("MovieOne");
        movieTwo.setMovieID(1);
        movieTwo.setDiscount(100);

        System.out.println(movieTwo);
        System.out.println("Movie are equal: " + (movieOne.equals(movieTwo) && movieTwo.equals(movieOne)));
    }
}