package login.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class BaseTest {
    private WebDriver driver;
    protected Properties prop;
    protected String validUserEmail;
    protected String validUserPassword;

    @BeforeTest
    public void beforeClass() {
        chromedriver().setup();
        setConfigProperties();

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    private void setConfigProperties() {
        prop = new Properties();

        FileInputStream ip;
        try {
            ip = new FileInputStream("config.properties");
            prop.load(ip);
            validUserEmail = prop.getProperty("VALID_USER_EMAIL");
            validUserPassword = prop.getProperty("VALID_USER_PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

