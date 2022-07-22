package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.header.HeaderComponent;

public class NewsPage extends BasePage {
    HeaderComponent header;
    private WebElement pageIdentifier;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
    }

    public WebElement getPageIdentity(){
        if (pageIdentifier == null) {
            pageIdentifier = driver.findElement(By.xpath("//a[@href='/dev/news']"));
        }
        return pageIdentifier;
    }
}
