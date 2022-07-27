package pages.header.profileMenuAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.header.HeaderComponent;

public class AddGroupModalComponent extends BasePage {

    WebElement closeGroupModal;
    WebElement groupHeader;

    public AddGroupModalComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getCloseGroupBtn() {
        if (closeGroupModal == null) {
            waitVisibilityOfElement(By.xpath("//button[@aria-label='Close']"));
            closeGroupModal = driver.findElement(By.xpath("//span[@aria-label='close']"));
        }
        return closeGroupModal;
    }

    public WebElement getGroupHeader() {
        if (groupHeader == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='add-club-header']"));
            groupHeader = driver.findElement(By.xpath("//div[@class='add-club-header']"));
        }
        return groupHeader;
    }

    public HeaderComponent clickOnCloseGroupBtn() {
        getCloseGroupBtn().click();
        return new HeaderComponent(driver);
    }

}
