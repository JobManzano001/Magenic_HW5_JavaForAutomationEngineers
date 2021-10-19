package models;

import resources.OptionStrings;
import utils.UserHelperMethods;

import java.util.List;
import java.util.Scanner;

public class MovieStore extends OptionStrings {
    /**
     * The movie database instance
     */
    private MovieDatabase movieDatabase;
    /**
     * The customer database instance
     */
    private CustomerDatabase customerDatabase;
    /**
     * Declaring Scanner to read inpyt from the user
     */
    private Scanner scanner;

    /**
     * initiate variables needed for lucky customeres
     */
    static int LuckyCustomerInQueue = 0;
    static int LuckyCounter = 1;
    boolean isLuckyCustomer = false;

    /**
     * Creates new MovieDatabse and Customer Database and sets Scanner
     */
    public MovieStore() {
        this.movieDatabase = new MovieDatabase();
        this.customerDatabase = new CustomerDatabase();
        this.scanner = new Scanner(System.in);
    }
    /**
     * get Movie Database
     * return movieDatabase
     */
    public MovieDatabase getMovieDatabase() {
        return movieDatabase;
    }
    /**
     * set Movie Database
     */
    protected void setMovieDatabase(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }
    /**
     * get Customer Database
     * return customerDatabase
     */
    public CustomerDatabase getCustomerDatabase() {
        return customerDatabase;
    }
    /**
     * sets Customer Database
     */
    public void setCustomerDatabase(CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    }

    /**
     * Method for displaying then Menu in the program
     */
    private void mainMenu() {
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(MAIN_MENU_OPTIONS);
        String userChoiceText = MAIN_MENU_OPTIONS[userChoice];

        if (userChoiceText.equals("Buy Movie")) {
            BUY_MOVIE();
        } else if (userChoiceText.equals("Manage Movie")) {
            MANAGE_MOVIE_MENU();
        } else if (userChoiceText.equals("View Lucky Customer")) {
            CUSTOMER_DETAILS();
        } else if (userChoiceText.equals("Search Movie")) {
            SEARCH_MOVIE();
        } else {
            System.out.println("Program terminated");
        }
    }

    /**
     * Method for displaying customer in the program
     */
    private void CUSTOMER_DETAILS(){
        System.out.println("List of Lucky Customers");
        UserHelperMethods.printLuckyCustomer(customerDatabase.getCustomerArchive());
        mainMenu();
    }

    /**
     * Method for displaying then Menu in the program
     */
    private void MANAGE_MOVIE_MENU() {
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(MANAGE_MOVIE_OPTIONS),movieID=0,quantity=0;
        double price = 0,discount = 0;
        String userChoiceText = MANAGE_MOVIE_OPTIONS[userChoice];

        switch (userChoiceText) {
            case "Movie List":
                UserHelperMethods.printMovie(movieDatabase.getMovieArchive());
                break;
            case "Add Movie":
                try {
                    movieID = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Movie ID: "));
                }
                catch (NumberFormatException e){
                    System.out.println("Please enter number only");
                    movieID = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Movie ID: "));
                }
                //prompt user to enter movie details
                String name = UserHelperMethods.getInputFromPrompt("Title: ");
                try{
                    price = Double.parseDouble(UserHelperMethods.getInputFromPrompt("Price: "));
                }catch (NumberFormatException e){
                    System.out.println("Please enter number only");
                    price = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Price: "));
                }
                try{
                    quantity = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Quantity: "));
                }
                catch (NumberFormatException e){
                    System.out.println("Please enter number only");
                    quantity = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Quantity: "));
                }
                try{
                    discount = Double.parseDouble(UserHelperMethods.getInputFromPrompt("Discount: "));
                }catch (NumberFormatException e){
                    System.out.println("Please enter number only");
                    discount = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Discount: "));
                }
                //save movie details
                movieDatabase.addMovie(new Movie(movieID,name, price, quantity,discount));
                break;
            case "Update Movie":
                UPDATE_MOVIE();
                break;
            case "Add stock":
                ADD_STOCK();
                break;
            case "Delete Movie":
                UserHelperMethods.printMovie(movieDatabase.getMovieArchive());
                movieID = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Enter Movie ID to delete: "));
                Movie movieToDelete = findMovie(movieID);
                movieDatabase.deleteMovie(movieToDelete);
                break;
            case "Delete All Movie":
                DELETE_ALL_MOVIE();
                break;
        }
        //go back to main menu
        mainMenu();
    }

    /**
     * Method for adding stock the movie
     */
    private void ADD_STOCK(){
        String movieTitle = UserHelperMethods.getInputFromPrompt("Enter Movie name to add stock: ");
        Movie movieToUpdate = findMovie(movieTitle);

        if (movieToUpdate != null) {
            int quantity = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Add stock: "));
            if(quantity>0){
                movieDatabase.updateMovieQuantity(movieToUpdate.getName(),
                        movieToUpdate.getQuantity() + quantity);
            }
            else
            {
                System.out.println("Invalid Stock count. Try again");
            }
        }
        else{
            System.out.println("Movie not found");
        }
    }

    /**
     * Method for updating the movie
     */
    private void UPDATE_MOVIE() {

        String movieTitle = UserHelperMethods.getInputFromPrompt("Enter Movie name to update: ");
        Movie movieToUpdate = findMovie(movieTitle);
        if (movieToUpdate != null) {
            String newMovieTitle = UserHelperMethods.getInputFromPrompt("Enter new Movie Title: ");
            movieDatabase.UpdateMovie(movieToUpdate.getName(), newMovieTitle);
        }
        else{
            System.out.println("Movie not found");
        }
    }
    /**
     * Method for displaying then Menu in the program
     */
    private void SEARCH_MOVIE() {
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(SEARCH_MOVIE_OPTIONS);
        String userChoiceText = SEARCH_MOVIE_OPTIONS[userChoice];
        switch (userChoiceText) {
            case "Search by Movie ID":
                int Id = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Enter ID: "));
                Movie searchedMovie = findMovie(Id);
                System.out.println(searchedMovie);
                break;
            case "Search by Movie Name":
                String movieName = UserHelperMethods.getInputFromPrompt("Enter Movie Name: ");
                Movie searchedMovieName = findMovie(movieName);
                System.out.println(searchedMovieName);
                break;
        }
        mainMenu();
    }

    /**
     * Method for adding the lucky customer of the movie store
     */
    private void AddLuckyCustomer(){
        if(LuckyCounter == LuckyCustomerInQueue){
            System.out.println(UserHelperMethods.LuckyCustomerMessage());
            String CustomerName = UserHelperMethods.getInputFromPrompt("Enter Customer Name: ");
            String CustomerAddress = UserHelperMethods.getInputFromPrompt("Enter Customer Address: ");
            customerDatabase.addLuckyCustomer(new Customer(CustomerName,CustomerAddress));

            isLuckyCustomer = true;
        }
    }

    /**
     * Finds the movie for the given movie Name
     * @param movieName The movie year
     * @return The movie object
     */
    private Movie findMovie(String movieName) {
        List<Movie> SearchedMovie = movieDatabase.findMovieByName(movieName);
        //return null when movie is empty
        if (SearchedMovie.isEmpty()) {
            System.out.println("MOVIE: " + movieName + " is not existing");
            return null;
        }
        //if movie is not empty, return searched movie
        else {
            int index = UserHelperMethods.displayOptionsAndWaitForValidOption(SearchedMovie);
            return SearchedMovie.get(index);
        }
    }
    /**
     * Finds the movie for the given movie ID
     * @param MovieID The movie year
     * @return The movie object
     */
    private Movie findMovie(int MovieID) {
        List<Movie> SearchedMovie = movieDatabase.findMovieByID(MovieID);
        if (SearchedMovie.isEmpty()) {
            System.out.println("MOVIE: " + MovieID + " is not existing");
            return null;
        } else {
           //return movie ID to delete
            return movieDatabase.findMovieByID(MovieID).stream().findFirst().get();
        }
    }

    /**
     * Buy method for the movie store
     * Contains processing of buying movies with discounted price and lucky customers
     */
    private void BUY_MOVIE() {
        //check lucky customer, if >0 then add
        AddLuckyCustomer();
        UserHelperMethods.printMovie(movieDatabase.getMovieArchive());
        String movieSelection = UserHelperMethods.getInputFromPrompt("Enter movie ID to proceed to buying the movie");
        Movie searchedMovie = findMovie(Integer.parseInt(movieSelection));

        //initialize total variables
        double total = 0;
        double totalWithDiscountedPrice = 0;
        double finalPrice = 0;

        if (searchedMovie != null) {

            //declare Movie Discount
            double MovieDiscount = searchedMovie.getDiscount();

            //override discount when lucky customer is found
            if(isLuckyCustomer){
                MovieDiscount = 50;
            }
            //Actual Quantity to be bought by customer
            int ActualQuantity = Integer.parseInt(UserHelperMethods.getInputFromPrompt("Enter quantity"));

            //If actual quantity is greater than the stock quantity, print that the movie does have insufficient stocks of the specific movie
            if (ActualQuantity > searchedMovie.getQuantity()) {
                System.out.println("Insufficient movie stocks.");
            }
            //if entered quantity is <1, then invalid quantity is supplied to the system
            else if (ActualQuantity <=0) {
                System.out.println("Please enter valid quantity only");
            }

            //when input is satisfied, continue buying the movie
            else {
                System.out.println("  MOVIE: " + searchedMovie.getName() + "\n  QUANTITY: " + ActualQuantity +
                        "\n  PRICE: " + searchedMovie.getPrice()  + " \n  DISCOUNT: " + MovieDiscount + "%");

                for (int i=0;i<ActualQuantity;i++){
                    total = ActualQuantity * searchedMovie.getPrice();
                    totalWithDiscountedPrice+= (MovieDiscount/100) * total ;
                    finalPrice = total - totalWithDiscountedPrice;
                }

                System.out.println("  TOTAL WITH DISCOUNTED PRICE: " + finalPrice );
                System.out.println("Confirm");

                int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(BUY_MOVIE_OPTIONS);
                String userChoiceText = BUY_MOVIE_OPTIONS[userChoice];

                //Confirm transaction
                if (userChoiceText.equals("Confirm")) {
                    movieDatabase.updateMovieQuantity(searchedMovie.getName(),
                            searchedMovie.getQuantity() - ActualQuantity);
                    System.out.println("MOVIE: " + searchedMovie.getName() + " with " + ActualQuantity +
                            " quantity is successfully bought.");

                    //increment lucky count once customer successfully bought a movie
                    LuckyCounter++;
                } else {
                    System.out.println("Transaction cancelled.");
                }
            }
        }
        System.out.println("Lucky Customer Count " + customerDatabase.getCustomerArchive().size());
        mainMenu();
    }

    private void DELETE_ALL_MOVIE(){
        UserHelperMethods.printMovie(movieDatabase.getMovieArchive());
        String confirmationCode = UserHelperMethods.getInputFromPrompt("Are you sure you want to delete all movie? Confirm by typing code '123456789'");
        movieDatabase.deleteAllMovie(confirmationCode);
    }

    public static void main(String[] args) {
        // Initializes the Movie Store console app
        MovieStore movieStore = new MovieStore();

        //Randomize lucky number of customer
        LuckyCustomerInQueue = UserHelperMethods.RandomLuckyNumberOfCustomer();

        //populate movie database
        movieStore.movieDatabase.addMovie(new Movie(1,"Whiskers Away", 500, 5,2));
        movieStore.movieDatabase.addMovie(new Movie(2,"Puss in boots", 500, 1,5));
        movieStore.movieDatabase.addMovie(new Movie(3,"Kiki's Delivery Service", 500.00, 5,5));

        //Prints welcome message for the lucky number of customer
        System.out.println("The lucky customer  is in the "+ UserHelperMethods.ParseLuckyNumberMessage(LuckyCustomerInQueue) +" customer in queue");
        System.out.println("Current customer queue is " + UserHelperMethods.ParseLuckyNumberMessage(LuckyCounter));

        //Opens main menu of the application
        movieStore.mainMenu();
    }
}