package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchPanelComponent extends BaseMethods {
    private List<WebElement> clubListSectionChildren;
    private WebElement asideAdvancedSearchMenu;
    private WebElement advancedSearchHeader;
    private WebElement citySelector;
    private WebElement basicCategoriesCheckList;

    public AdvancedSearchPanelComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getAsideAdvancedSearchMenu() {
        if (asideAdvancedSearchMenu == null) {
            waitVisibilityOfElement(By.xpath("//aside"), Duration.ofSeconds(2));
            asideAdvancedSearchMenu = driver.findElement(By.xpath("//aside"));
        }
        return asideAdvancedSearchMenu;
    }

    public WebElement getAdvancedSearchHeader() {
        if (advancedSearchHeader == null) {
            advancedSearchHeader = driver.findElement(By.xpath("//div[@class='club-list-label']"));
        }
        return advancedSearchHeader;
    }

    public WebElement getCitySelector() {
        if (citySelector == null) {
            citySelector = driver.findElement(By.xpath("//input[@id='basic_cityName']//ancestor::div[contains(@class, 'selector')]"));
        }
        return citySelector;
    }

    public WebElement getBasicCategoriesCheckList() {
        if (basicCategoriesCheckList == null) {
            basicCategoriesCheckList = driver.findElement(By.xpath("//div[@id='basic_categoriesName']"));
        }
        return basicCategoriesCheckList;
    }

    public List<WebElement> getClubListSectionChildren() {
        clubListSectionChildren = driver.findElements(By.xpath("//section[contains(@class, 'club-list')]/child::*"));
        return clubListSectionChildren;
    }

}
