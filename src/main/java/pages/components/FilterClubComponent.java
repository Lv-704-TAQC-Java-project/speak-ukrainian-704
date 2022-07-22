package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

public class FilterClubComponent extends BaseMethods {

    private WebElement sortByABCButton;
    private WebElement sortByRatingButton;
    private WebElement arrowUpButton;
    private WebElement arrowDownButton;
    private WebElement listViewButton;
    private WebElement blockViewButton;

    public FilterClubComponent(WebDriver driver) {
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
            arrowUpButton = driver.findElement(By.xpath("//div/span[@aria-label = 'arrow-up']"));
        }
        return arrowUpButton;
    }

    public WebElement getArrowDownButton() {
        if (arrowDownButton == null) {
            arrowDownButton = driver.findElement(By.xpath("//div/span[@aria-label = 'arrow-down']"));
        }
        return arrowDownButton;
    }

    public WebElement getListViewButton() {
        if (listViewButton == null) {
            listViewButton = driver.findElement(By.xpath("//div/label[@class = 'ant-radio-button-wrapper ant-radio-button-wrapper-checked club-view-button']"));
        }
        return listViewButton;
    }

    public WebElement getBlockViewButton() {
        if (blockViewButton == null) {
            blockViewButton = driver.findElement(By.xpath("//div/label[@class = 'ant-radio-button-wrapper club-view-button']"));
        }
        return blockViewButton;
    }

    public FilterClubComponent sortByABCButtonClick() {
        getSortByABCButton().click();
        return this;
    }

    public FilterClubComponent sortByRatingButtonClick() {
        getSortByRatingButton().click();
        return this;
    }

    public FilterClubComponent arrowUpButtonClick() {
        getArrowUpButton().click();
        return this;
    }

    public FilterClubComponent arrowDownButtonClick() {
        getArrowDownButton().click();
        return this;
    }

    public FilterClubComponent listViewButtonClick() {
        getListViewButton().click();
        return this;
    }

    public FilterClubComponent blockViewButtonClick() {
        getBlockViewButton().click();
        return this;
    }

}
