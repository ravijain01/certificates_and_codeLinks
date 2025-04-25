package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testCases.BaseClass;

public class HomePage extends BasePage {
    //constructor
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //locator

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement user;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement login;


    //Action
    public void userbtn()
    {
        user.sendKeys("standard_user");
    }

    public void passwordbtn()
    {
        password.sendKeys("secret_sauce");
    }

    public void loginbtn()
    {
        login.click();
    }

}
