import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseMethods {

    protected WebDriver driver;

    final String BASE_URL = "https://speak-ukrainian.org.ua/dev/";

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(BASE_URL);
    }

    @AfterClass
    public void AfterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }




}
