package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //Locators
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement txt_username_loc;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password_loc;

    @FindBy(xpath = "//input[@name='login-button']")
    WebElement btn_login_loc;


    //Action Methods
    public void setUserName(String user)
    {
        txt_username_loc.sendKeys(user);
    }

    public void setPass(String pwd)
    {
        txt_password_loc.sendKeys(pwd);
    }

    public void clickLogin()
    {
        btn_login_loc.click();
    }
}
