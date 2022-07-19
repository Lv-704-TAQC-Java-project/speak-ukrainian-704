package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProfilePage extends BasePage {
    private WebElement currentUserEmailField;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCurrentUserEmailField() {
        if (currentUserEmailField == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='user-email-data']"));
            currentUserEmailField = driver.findElement(By.xpath("//div[@class='user-email-data']"));
        }
        return currentUserEmailField;
    }
}
