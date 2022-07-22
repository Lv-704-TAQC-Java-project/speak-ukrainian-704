package pages;

import org.openqa.selenium.*;


public class HomePage extends BasePageWithHeader {
    private WebElement advancedSearchButton;


    public HomePage(WebDriver driver) {
        super(driver);
        waitForPageToReload();
    }

    public WebElement getAdvancedSearchButton() {
        if (advancedSearchButton == null) {
            waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
            advancedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return advancedSearchButton;
    }


    public ClubsPage clickAdvancedSearchButton() {
        getAdvancedSearchButton().click();
        return new ClubsPage(driver);
    }


}
