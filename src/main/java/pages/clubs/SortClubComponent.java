package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.util.List;

public class SortClubComponent extends BasePage {

    private WebElement sortByABCButton;
    private WebElement sortByRatingButton;
    private WebElement arrowUpButton;
    private WebElement arrowDownButton;
    private WebElement listViewButton;
    private WebElement blockViewButton;

    public SortClubComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getSortByABCButton() {
        if (sortByABCButton == null) {
            sortByABCButton = driver.findElement(By.xpath("//div/span[contains(text(), 'за алфавітом')]"));
        }
        return sortByABCButton;
    }

    public WebElement getSortByRatingButton() {
        if (sortByRatingButton == null) {
            sortByRatingButton = driver.findElement(By.xpath("//div/span[contains(text(), 'за рейтингом')]"));
        }
        return sortByRatingButton;
    }

    public WebElement getArrowUpButton() {
        if (arrowUpButton == null) {
            waitVisibilityOfElements(By.xpath("//div/span[@aria-label = 'arrow-up']"));
            arrowUpButton = driver.findElement(By.xpath("//div/span[@aria-label = 'arrow-up']"));
        }
        return arrowUpButton;
    }

    public WebElement getArrowDownButton() {
        if (arrowDownButton == null) {
            waitVisibilityOfElements(By.xpath("//div/span[@aria-label = 'arrow-down']"));
            arrowDownButton = driver.findElement(By.xpath("//div/span[@aria-label = 'arrow-down']"));
        }
        return arrowDownButton;
    }

    public WebElement getListViewButton() {
        if (listViewButton == null) {
            listViewButton = driver.findElement(By.xpath("//div/label[@class = 'ant-radio-button-wrapper club-view-button']"));
        }
        return listViewButton;
    }

    public WebElement getBlockViewButton() {
        if (blockViewButton == null) {
            blockViewButton = driver.findElement(By.xpath("//div/label[@class = 'ant-radio-button-wrapper ant-radio-button-wrapper-checked club-view-button']"));

        }
        return blockViewButton;
    }

    public SortClubComponent sortByABCButtonClick() {
        waitElementIsClickable(getSortByABCButton());
        List<WebElement> cardNameList = new ClubsPage(driver).getClubPageComponent().getCardNamesList();
        getSortByABCButton().click();
        if (!cardNameList.isEmpty() && cardNameList.get(1).toString().equals(new ClubsPage(driver).getClubPageComponent().getCardNamesList().get(1).toString())) {
            waitInvisibilityOfElement(cardNameList.get(1));
        }
        return this;
    }

    public SortClubComponent sortByRatingButtonClick() {
        waitElementIsClickable(getSortByRatingButton());
        List<WebElement> cardNameList = new ClubsPage(driver).getClubPageComponent().getCardNamesList();
        getSortByRatingButton().click();
        if (!cardNameList.isEmpty() && cardNameList.get(1).toString().equals(new ClubsPage(driver).getClubPageComponent().getCardNamesList().get(1).toString())) {
            waitInvisibilityOfElement(cardNameList.get(1));
        }
        return this;
    }

    public SortClubComponent arrowUpButtonClick() {
        waitElementIsClickable(getArrowUpButton());
        List<WebElement> cardNameList = new ClubsPage(driver).getClubPageComponent().getCardNamesList();
        getArrowUpButton().click();
        if (!cardNameList.isEmpty() && cardNameList.get(1).toString().equals(new ClubsPage(driver).getClubPageComponent().getCardNamesList().get(1).toString())) {
            waitInvisibilityOfElement(cardNameList.get(1));
        }
        return this;

    }

    public SortClubComponent arrowDownButtonClick() {
        waitElementIsClickable(getArrowDownButton());
        List<WebElement> cardNameList = new ClubsPage(driver).getClubPageComponent().getCardNamesList();
        getArrowDownButton().click();
        if (!cardNameList.isEmpty() && cardNameList.get(1).toString().equals(new ClubsPage(driver).getClubPageComponent().getCardNamesList().get(1).toString())) {
            waitInvisibilityOfElement(cardNameList.get(1));
        }
        return this;
    }

    public SortClubComponent listViewButtonClick() {
        getListViewButton().click();
        return this;
    }

    public SortClubComponent blockViewButtonClick() {
        getBlockViewButton().click();
        return this;
    }

}
