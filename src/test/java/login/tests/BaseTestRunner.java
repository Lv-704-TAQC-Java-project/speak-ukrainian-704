package login.tests;

import login.tests.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import pages.HomePage;


public class BaseTestRunner {
    protected final String BASE_URL = "https://speak-ukrainian.org.ua/dev/";
    protected WebDriver driver;
    protected ConfigProperties configProps;
    protected HomePage homePage;

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeClass
    public void beforeClass() {
        configProps = new ConfigProperties();
    }

    @BeforeTest
    public void beforeTest() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
        if (homePage != null) {
            homePage = null;
        }
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            driver.get(BASE_URL);
            homePage = new HomePage(driver);
        }
        return homePage;
    }


}

