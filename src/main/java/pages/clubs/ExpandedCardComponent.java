package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExpandedCardComponent extends BasePage {
    private WebElement exitButton;
    private List<WebElement> listOfCategories;

    public ExpandedCardComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getExitButton() {
        if (exitButton == null) {
            waitVisibilityOfElement(By.xpath("//button[contains(@class,'close')]"), Duration.ofSeconds(2));
            exitButton = driver.findElement(By.xpath("//button[contains(@class,'close')]"));
        }
        return exitButton;
    }

    public List<WebElement> getListOfCategories() {
        waitVisibilityOfElement(By.xpath("//div[@class='container']//span[@class='name']"), Duration.ofSeconds(2));
        return driver.findElements(By.xpath("//div[@class='container']//span[@class='name']"));
    }

    public List<String> getListOfNamesOfCategories(){
        List<String> listOfNameOfCategories = new ArrayList<>();
        List<WebElement> listOfCategories = getListOfCategories();
        for (WebElement category : listOfCategories){
            listOfNameOfCategories.add(category.getText());
        }
        return listOfNameOfCategories;
    }
    public ClubsPage exitButtonClick() {
        waitElementIsClickable(getExitButton());
        getExitButton().click();
        return new ClubsPage(driver);
    }
}