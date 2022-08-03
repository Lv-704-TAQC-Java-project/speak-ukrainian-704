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
    private WebElement ageDescription;

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

    public String getAgeDescription() {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-modal-body']//div[@class='age']//span[@class='years']"), Duration.ofSeconds(2));
            ageDescription = driver.findElement(By.xpath("//div[@class='ant-modal-body']//div[@class='age']//span[@class='years']"));
        return ageDescription.getText();
    }

    public Integer[] getAgeRestriction(){
        String line = getAgeDescription();
        String regex = "[^\\d]+";
        String[] splitedLine = line.split(regex);
        Integer[] intLine = new Integer[2];

        for(int i = 1; i <= splitedLine.length - 1; i++){
            intLine[i-1] = Integer.parseInt(splitedLine[i]);
        }
        return intLine;
    }

    public List<WebElement> getListOfCategories() {
        waitVisibilityOfElement(By.xpath("//div[@class='container']//span[@class='name']"), Duration.ofSeconds(2));
        listOfCategories = driver.findElements(By.xpath("//div[@class='container']//span[@class='name']"));
        return listOfCategories;
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
        getExitButton().click();
        return new ClubsPage(driver);
    }
}