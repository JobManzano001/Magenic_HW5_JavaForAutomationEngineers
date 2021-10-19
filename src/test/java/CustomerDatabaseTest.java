import models.Customer;
import models.CustomerDatabase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerDatabaseTest {
    /*
    * This test is for adding customer
    * */
    @Test
    public void testAddCustomer(){
        CustomerDatabase db = new CustomerDatabase();
        Customer customer = new Customer("Job Manzano", "Pangasinan");
        Customer newCustomer = new Customer("Testing Customer", "Umknown");
        db.addLuckyCustomer(customer);
        db.addLuckyCustomer(newCustomer);

        //Verify new added customer
        Assert.assertTrue(db.getCustomerArchive().contains(customer));
        //Verify second customer is added
        Assert.assertTrue(db.getCustomerArchive().contains(newCustomer));
    }
}
