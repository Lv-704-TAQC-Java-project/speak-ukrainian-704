package pages.header.profileMenuAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.header.HeaderComponent;

public class AddCenterModalComponent extends BasePage {

    WebElement closeCenterModal;
    WebElement centerHeader;

    public AddCenterModalComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getCloseCenterBtn() {
        if (closeCenterModal == null) {
            waitVisibilityOfElement(By.xpath("//span[@aria-label='close']"));
            closeCenterModal = driver.findElement(By.xpath("//span[@aria-label='close']"));
        }
        return closeCenterModal;
    }

    public WebElement getCenterHeader() {
        if (centerHeader == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='modal-title']"));
            centerHeader = driver.findElement(By.xpath("//div[@class='modal-title']"));
        }
        return centerHeader;
    }

    public HeaderComponent clickOnCloseCenterBtn() {
        getCloseCenterBtn().click();
        return new HeaderComponent(driver);
    }

}
