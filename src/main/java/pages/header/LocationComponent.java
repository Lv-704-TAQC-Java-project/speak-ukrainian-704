package pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        if (locationMenuButton == null) {
            locationMenuButton = driver.findElement(By.xpath("//div[contains(@class, 'city') and contains(@class, 'dropdown')]"));
        }
        return locationMenuButton;
    }

    public List<WebElement> getLocationList() {
        if (locationList == null) {
            locationList = driver.findElements(By.xpath("//div[contains(@class, 'dropdown')]//li[contains(@class, 'menu-item')]"));
        }
        return locationList;
    }

    public WebElement getLocationMenu() {
        if (locationMenu == null) {
            locationMenu = driver.findElement(By.xpath("//div[contains(@class, 'dropdown')]//ul"));
        }
        return locationMenu;
    }

    public WebElement getLocationLinkByCityName(String city) {
        driver.findElements(By.xpath("//div[contains(@class, 'ant-dropdown-show-arrow') and not(contains(@class, 'hidden'))]//li[contains(@class, 'dropdown-menu-item')]"));
        return driver.findElement(By.xpath(String.format("//span[contains(@class, 'title-content') and contains(text(), '%s')]", city)));
    }

    public void selectLocationByCity(String city) {
        getLocationLinkByCityName(city).click();
        waitVisibilityOfElement(By.xpath("//div[contains(@class, 'trigger city')]"));
        try {
            waitForTextPresentInElement(new ClubsPage(driver).getHeaderTitle(), city);
        } catch (TimeoutException ignored) {}
    }

    public LocationComponent clickLocationMenuButton() {
        getLocationMenuButton().click();
        return this;
    }
}
