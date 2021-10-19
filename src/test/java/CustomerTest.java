import models.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {
    /**
     * This test is for the 'Getters'
     */
    @Test
    public void TestCustomerGetters() {
        String name = "Job Manzano";
        String address = "Pangasinan";

        models.Customer customers = new Customer(name,address);
        Assert.assertEquals(customers.getCustomerName(), name);
        Assert.assertEquals(customers.getCustomerAddress(), address);
    }
}
