package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(className = "inventory_item")
    List<WebElement> products;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement tap;


    public void clickMyAccount(String productName)
    {
        products.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName))
                .findFirst().orElseThrow().findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"))
                .click();
    }

    public void cart()
    {
        tap.click();
    }
}
