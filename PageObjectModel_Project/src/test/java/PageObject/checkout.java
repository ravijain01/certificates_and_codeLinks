package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout extends BasePage {

    public checkout(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement txtFirstname;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement txtZip;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continuebtn;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishbtn;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement backbtn;


    public void Checkout()
    {
        checkout.click();
    }
    public void setFirstname(String fname)
    {
        txtFirstname.sendKeys(fname);
    }
    public void setLastname(String lname)
    {
        txtLastname.sendKeys(lname);
    }

    public void setZip(String code)
    {
        txtZip.sendKeys(code);
    }

    public void setContinue()
    {
        continuebtn.click();
    }

    public void setFinish()
    {
        finishbtn.click();
    }

    public void backHome()
    {
        backbtn.click();
    }
}
