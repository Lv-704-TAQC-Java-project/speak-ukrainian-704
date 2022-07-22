package pages;

import org.openqa.selenium.WebDriver;
import pages.header.HeaderComponent;

public class AboutPage extends BasePage {
    private HeaderComponent header;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
    }
}
