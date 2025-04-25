package testCases;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.checkout;
import org.testng.annotations.Test;

public class TC001_AddtoCart extends BaseClass{
    @Test
    public void confirmation()
    {
        HomePage hp=new HomePage(driver);
        hp.userbtn();
        hp.passwordbtn();
        hp.loginbtn();
        LoginPage lp=new LoginPage(driver);
        lp.clickMyAccount("Sauce Labs Backpack");
        lp.clickMyAccount("Sauce Labs Bike Light");

        lp.cart();
        checkout ck=new checkout(driver);
        ck.Checkout();
        ck.setFirstname("Ravi");
        ck.setLastname("Jain");
        ck.setZip("302033");
        ck.setContinue();
        ck.setFinish();
        ck.backHome();
    }
}
