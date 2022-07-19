package base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver webDriver) {
        driver = webDriver;
    }


}
