package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeClass
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @Test
    void testLogin()
    {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName("standard_user");
        lp.setPass("secret_sauce");
        lp.clickLogin();
//        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }


//    @AfterClass
//    void tearDown()
//    {
//        driver.quit();
//    }
}
