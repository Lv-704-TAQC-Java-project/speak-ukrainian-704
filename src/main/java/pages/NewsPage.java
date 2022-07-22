package pages;

import org.openqa.selenium.WebDriver;
import pages.header.HeaderComponent;

public class NewsPage extends BasePage {
    HeaderComponent header;
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
    }
}
