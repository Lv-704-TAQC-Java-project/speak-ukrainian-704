package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.header.HeaderComponent;

public class ServicePage extends BasePage {
    private HeaderComponent header;
    private WebElement pageIdentifier;
    public ServicePage(WebDriver driver) {
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
            pageIdentifier = driver.findElement(By.xpath("//section[@class='ant-layout serviceInUkr global-padding']"));
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
