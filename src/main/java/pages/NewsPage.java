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

    public boolean getPageIdentity(){
        try {
            pageIdentifier = driver.findElement(By.xpath("//div[@class='global-padding news-content']"));
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
