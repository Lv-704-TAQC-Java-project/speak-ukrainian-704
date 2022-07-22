package pages;

import org.openqa.selenium.*;
import pages.clubs.ClubsPage;
import pages.header.HeaderComponent;


public class HomePage extends BasePage {
    private HeaderComponent header;
    private WebElement advancedSearchButton;



    public HomePage(WebDriver driver) {
        super(driver);
//        waitForPageToReload();
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
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
