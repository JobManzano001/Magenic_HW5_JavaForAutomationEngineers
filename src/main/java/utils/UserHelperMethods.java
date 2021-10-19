package utils;

import models.Customer;
import models.Movie;

import java.util.*;


public class UserHelperMethods {

    /**
     * Prints the given array to the console
     * @param array The array to be printed
     */
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }
    /**
     * Prints the given movie list to the console
     * @param movies The list of movies
     */
    public static void printMovie(List<Movie> movies) {
        if(movies.size()>0){
            System.out.println("Movie List");
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(movies.get(i));
            }
        }else{
            System.out.println("0 Records found");
        }

    }
    /**
     * Prints the given lucky customer to the console
     * @param customer The list of movies
     */
    public static void printLuckyCustomer(List<Customer> customer) {
        //prints customer when list is not less than 1
        if(customer.size()>0){
            for (int i = 0; i < customer.size(); i++) {
                System.out.println(customer.get(i));
            }
        }else{
            //print when list is empty
            System.out.println("0 Records found");
        }
    }
    /**
     * Prints the given options to the console and prompts the user
     * @param options The list of options
     */
    public static void printOptions(String[] options) {
        printArray(options);
        System.out.println("Please enter the number of selected option");
    }
    /**
     * Displays the options and waits for the user to enter a valid options
     * @param options The array of options
     * @return The index of the selected option
     */
    public static int displayOptionsAndWaitForValidOption(String[] options) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        printOptions(options);
        do {
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);

                if (option >= 0 && option <= options.length) {
                    return option;
                }
                printOptions(options);
            } catch (NumberFormatException e) {
                printOptions(options);
            }
        } while (true);
    }
    /**
     * Displays the movie options and waits for the user to enter a valid options
     * @param movieOptions The list of movie options
     * @return The index of the selected movie option
     */
    public static int displayOptionsAndWaitForValidOption(List<Movie> movieOptions) {
        String[] movieText = new String[movieOptions.size()];

        for (int i = 0; i < movieOptions.size(); i++) {
            movieText[i] = movieOptions.get(i).toString();
        }

        return displayOptionsAndWaitForValidOption(movieText);
    }
    /**
     * Gets the string input from a prompt
     * @param prompt The prompt for the user
     * @return The entered text from the prompt
     */
    public static String getInputFromPrompt(String prompt) {
        System.out.println(prompt);
        String selection = "";
            try {
                Scanner scanner = new Scanner(System.in);
                selection = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Invalid data. Please try again.");
                System.out.println(prompt);
            }
        return selection;
    }

    //Generates lucky customer queue from 1 - 3
    public static int RandomLuckyNumberOfCustomer(){
        Random random = new Random();
        return random.nextInt(3-1)+1;
    }

    //print lucky customer message
    public static String LuckyCustomerMessage(){
        return "You are the lucky Customer. You will be given 50% discount in all our products";
    }
    //
    /**
     * parse queue and return string
     * @param queue The prompt for the user
     * @return The entered format of the message
     */
    public static String ParseLuckyNumberMessage(int queue){
        switch (queue)
        {
            case 0:
                return "0/Zero";
            case 1:
                return queue+"st";
            case 2:
                return queue+"nd";
            case 3:
                return queue+"rd";
            default:
                return queue+"th";
        }
    }
}