package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ProfilePage extends BasePage {
    private final String currentUserEmailFieldPath = "//div[@class='user-email-data']";


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage checkCurrentUserEmailEqualsExpected(String email) {
        waitVisibilityOfElement(By.xpath(currentUserEmailFieldPath));
        WebElement currentUserEmailField = driver.findElement(By.xpath(currentUserEmailFieldPath));
        Assert.assertEquals(email, currentUserEmailField.getText());
        return this;
    }
}
