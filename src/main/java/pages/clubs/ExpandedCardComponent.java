package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class ExpandedCardComponent extends BasePage {
    private WebElement exitButton;
    private List<WebElement> listOfCategories;

    private WebElement nameOfCategoryOnCard;

    public ExpandedCardComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getExitButton() {
        if (exitButton == null) {
//            waitVisibilityOfElement(By.xpath("//button[contains(@class,'close')]"), Duration.ofSeconds(3));
            exitButton = driver.findElement(By.xpath("//button[contains(@class,'close')]"));
        }
        return exitButton;
    }

    public List<WebElement> getListOfCategories() {
        sleep(5);
        waitVisibilityOfElement(By.xpath("//div[@class='container']//span[@class='name']"), Duration.ofSeconds(5));
        listOfCategories =  driver.findElements(By.xpath("//div[@class='container']//span[@class='name']"));
        return listOfCategories;
    }

    public WebElement getNameOfCategoryOnCard(WebElement category) {
        waitVisibilityOfElement(By.xpath("//div[@class='container']//span[@class='name']"), Duration.ofSeconds(3));
        return category.findElement(By.xpath("//span[@class='name']"));
    }

    public ClubPageComponent exitButtonClick() {
        waitElementIsClickable(getExitButton());
        getExitButton().click();
        return new ClubPageComponent(driver);
    }
}
