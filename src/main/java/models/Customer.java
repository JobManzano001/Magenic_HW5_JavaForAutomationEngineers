package models;

public class Customer implements Comparable<Customer> {
    /**
     * The name of the customer
     */
    private String customerName ;
    /**
     * The address of the customer
     */
    private String customerAddress;
    /**
     * Creates an instance of the Customer class
     * @param customerName The customer name
     */
    public Customer(String customerName) {
        this.customerName = customerName;
    }
    /**
     * Creates an instance of the Customer class
     * @param customerName The customer name
     * @param customerAddress The customer address
     */
    public Customer(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }
    /**
     * Gets customer name
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Sets the customer name
     * @param customerName The customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * Gets customer address
     * @return The customer address
     */
    public String getCustomerAddress() {
        return customerAddress;
    }
    /**
     * Sets the customer address
     * @param customerAddress The customer name
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    /**
     * IMPORTANT NOTE: THIS METHOD IS NEEDED FOR SIMPLICITY IN THE HOMEWORK, BUT IT IS NOT BEGINNER FRIENDLY YOU DO NOT NEED TO TOUCH THIS METHOD
     *                 For anyone who wants to learn more about compareTo read this link, but you have been warned: https://medium.com/omarelgabrys-blog/comparing-objects-307400115f88
     * @param o The other movie object
     * @return 0 if the movie are equal and other numbers if not
     */
    @Override
    public int compareTo(Customer o) {
        if(this.getCustomerName().compareTo(o.getCustomerName())>0)
            return 1;
        else if(this.getCustomerName().compareTo(o.getCustomerName())<0)
            return -1;
        else
            return 0;
    }
    /**
     * Converters a models.Movie to a string description
     * @return The string representation of a 'models.Movie' object
     */
    @Override
    public String toString() {
        return "Lucky Customer for the day is: " + getCustomerName() +  " from " + getCustomerAddress();
    }
    //main method of the class
    public static void main(String[] args) {

        //populate customer database
        Customer customer1 = new Customer("Job Manzano ", "Pangasinan");
        Customer customer2 = new Customer("QA Tester ", "Office");
        Customer customer3 = new Customer("QA Tester ", "Office");

        //compare customer1 to customer2
        customer1.compareTo(customer2);
        customer2.compareTo(customer3);

        //print customers
        System.out.println(customer1);
        System.out.println(customer2);


        System.out.println("Customer are equal: " + customer1.equals(customer2));

        customer2.setCustomerName("Customer1 ");
        customer2.setCustomerAddress("test ");

        System.out.println(customer2);
        System.out.println("Customer are equal: " + (customer1.equals(customer2) && customer2.equals(customer1)));
    }
}
