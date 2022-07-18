import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseMethods {

    protected final String BASE_URL = "https://speak-ukrainian.org.ua/dev/";
    protected WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void AfterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void getHomepage() {
        driver.get(BASE_URL);
    }




}
