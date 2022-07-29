package pages.header;

import org.openqa.selenium.*;

import java.util.List;
import pages.BasePage;
import pages.clubs.ClubsPage;


public class LocationComponent extends BasePage {
    WebElement locationMenuButton;
    WebElement locationMenu;
    List<WebElement> locationList;

    public LocationComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLocationMenuButton() {
        locationMenuButton = driver.findElement(By.xpath("//div[contains(@class, 'city') and contains(@class, 'dropdown')]"));
        return locationMenuButton;
    }

    public List<WebElement> getLocationList() {
        waitVisibilityOfElements(By.xpath("//div[contains(@class, 'dropdown') and not(contains(@class, 'hidden'))]//li[contains(@class, 'menu-item')]"));
        locationList = driver.findElements(By.xpath("//div[contains(@class, 'dropdown') and not(contains(@class, 'hidden'))]//li[contains(@class, 'menu-item')]"));
        return locationList;
    }

    public WebElement getLocationMenu() {
        if (locationMenu == null) {
            locationMenu = driver.findElement(By.xpath("//div[contains(@class, 'dropdown')]//ul"));
        }
        return locationMenu;
    }

    public WebElement getLocationLinkByCityName(String city) {
        waitVisibilityOfElements(By.xpath("//div[contains(@class, 'dropdown') and not(contains(@class, 'hidden'))]//li[contains(@class, 'menu-item')]"));
        return driver.findElement(By.xpath(String.format("//span[contains(@class, 'title-content') and contains(text(), '%s')]", city)));
    }

    public void selectLocationByCity(String city) {
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", getLocationLinkByCityName(city));
        getLocationLinkByCityName(city).click();
        waitVisibilityOfElement(By.xpath("//div[contains(@class, 'trigger city')]"));
        try {
            waitForTextPresentInElement(new ClubsPage(driver).getHeaderTitle(), city);
        } catch (TimeoutException ignored) {
        }
    }

    public void selectLocation(WebElement location) {
        location.click();
        waitVisibilityOfElement(By.xpath("//div[contains(@class, 'trigger city')]"));
        try {
            waitForTextPresentInElement(new ClubsPage(driver).getHeaderTitle(), location.getText());
        } catch (TimeoutException ignored) {
        }
    }

    public LocationComponent clickLocationMenuButton() {
        getLocationMenuButton().click();
        return this;
    }
}
