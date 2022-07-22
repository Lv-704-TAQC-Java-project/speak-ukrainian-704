package pages;

import org.openqa.selenium.WebDriver;
import pages.header.HeaderComponent;

public class ServicePage extends BasePage {
    private HeaderComponent header;
    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
    }
}
