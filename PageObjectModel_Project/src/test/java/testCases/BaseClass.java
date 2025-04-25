package testCases;
// 9928112816
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
public class BaseClass {
    public WebDriver driver;
    @BeforeClass
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void end()
    {
        driver.close();
    }
}
