package pages.header;

import org.openqa.selenium.*;

import java.util.List;
import pages.BasePage;
import pages.clubs.ClubsPage;


public class MapLocationComponent extends BasePage {
    WebElement locationMenuButton;
    WebElement locationMenu;
    List<WebElement> locationList;

    public MapLocationComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getMapLocationMenuButton() {
        if (locationMenuButton == null) {
            locationMenuButton = driver.findElement(By.xpath("//input[@id='mapCitiesList']/ancestor::div[@class='ant-select-selector']"));
        }
        return locationMenuButton;
    }



    public WebElement getMapLocationLinkByCityName(String city) {
        getMapLocationMenuButton().click();
        driver.findElements(By.xpath("//div[contains(@class, 'selector') and not(contains(@class, 'hidden'))]//li[contains(@class, 'dropdown-menu-item')]"));
        return driver.findElement(By.xpath(String.format("//span[contains(@class, 'ant-select-selection-item') and contains(text(), '%s')]", city)));
    }
    public void selectMapLocationByCity(String city) {
        waitVisibilityOfElement(By.xpath("//input[@id='mapCitiesList']/ancestor::div[@class='ant-select-selector']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getMapLocationLinkByCityName(city));
        try {
            waitForTextPresentInElement(new ClubsPage(driver).getMapHeaderTitle(), city);
        } catch (TimeoutException ignored) {}
    }
    public WebElement getLocationMenu() {
        if (locationMenu == null) {
            locationMenu = driver.findElement(By.xpath("//button[@class= 'ant-btn ant-btn-default flooded-button show-map-button' and contains(@class, 'dropdown')]"));
        }
        return locationMenu;
    }

}
