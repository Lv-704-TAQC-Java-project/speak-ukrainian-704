import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

abstract public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setUpBeforeClass() {
//        chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new BasePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProvider.URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void waitForPageToLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState;").equals("complete")); //"interactive"
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
}
