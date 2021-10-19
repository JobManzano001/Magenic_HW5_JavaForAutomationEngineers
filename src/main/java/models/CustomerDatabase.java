package models;
import utils.UserHelperMethods;
import java.util.*;

public class CustomerDatabase {
    //list of customers
    private List<Customer> customerArchive;
    //create instance of the CustomerDatabase
    public CustomerDatabase() {
        customerArchive = new ArrayList<Customer>();
    }
    /**
     * Gets the customerArchive
     * @return the customerArchive
     */
    public List<Customer> getCustomerArchive(){
        return customerArchive;
    }
    /**
     * sets the customerArchive
     */
    public void setCustomerArchive(List<Customer> customerArchive) {
        this.customerArchive = customerArchive;
    }
    /**
     * add customer in customerDatabase
     * @param luckyCustomer The customer
     */
    public void addLuckyCustomer(Customer luckyCustomer) {
        customerArchive.add(luckyCustomer);
        System.out.println(luckyCustomer.getCustomerName() +  " has been successfully saved");
    }
    /**
     * The main method of the class
     */
    public static void main(String[] args) {
        CustomerDatabase customerDatabase = new CustomerDatabase();

        customerDatabase.addLuckyCustomer(new Customer("Lucky Customer 1","Address1"));
        customerDatabase.addLuckyCustomer(new Customer("Lucky Customer 2","Address2"));

        UserHelperMethods.printLuckyCustomer(customerDatabase.customerArchive);

        System.out.println("lucky Customer count " + customerDatabase.getCustomerArchive().size());
    }
}
