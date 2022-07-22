package pages;

import org.openqa.selenium.*;
import pages.components.AdvancedSearchPanelComponent;
import pages.components.PaginationComponent;

import java.util.List;


public class ClubsPage extends Header {
    private PaginationComponent paginationComponent;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private WebElement advancedSearchButton;


    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage waitForClubsPageToOpen() {
        waitForPageToReload();
        return this;
    }

    public AdvancedSearchPanelComponent getAdvancedSearchPanelComponent() {
        if (advancedSearchPanelComponent == null) {
            advancedSearchPanelComponent = new AdvancedSearchPanelComponent(driver);
        }
        return advancedSearchPanelComponent;
    }

    public PaginationComponent getPaginationComponent() {
        if (paginationComponent == null) {
            paginationComponent = new PaginationComponent(driver);
        }
        return paginationComponent;
    }

    public PaginationComponent openPaginationComponent(){
        return getPaginationComponent().waitForPaginationComponentToOpen();
    }


    public WebElement getAdvancedSearchButton() {
        waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        if (advancedSearchButton == null) {
            advancedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return advancedSearchButton;
    }

    public String getAdvancedSearchHeaderText() {
        return getAdvancedSearchPanelComponent().getAdvancedSearchHeader().getText();
    }


    public boolean advancedSearchSideMenuIsVisible() {
        return getAdvancedSearchPanelComponent().getAsideAdvancedSearchMenu().isDisplayed();
    }

    public boolean citySelectionInputIsVisible() {
        return getAdvancedSearchPanelComponent().getCitySelector().isDisplayed();
    }

    public boolean basicCategoriesCheckListIsVisible() {
        return getAdvancedSearchPanelComponent().getBasicCategoriesCheckList().isDisplayed();
    }

    public AdvancedSearchPanelComponent clickAdvancedSearchButton() {
        getAdvancedSearchButton().click();
        return getAdvancedSearchPanelComponent();
    }

    public boolean advancedAsideMenuIsVisible() {
        try {
            return getAdvancedSearchPanelComponent().getAsideAdvancedSearchMenu().isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

}
