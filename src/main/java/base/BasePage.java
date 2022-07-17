package base;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    public static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
