package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CardComponent extends BasePage {

    private WebElement cardBody;
    List<WebElement> starRatingZeroList;
    List<WebElement> starRatingFullList;
    List<WebElement> cardNamesList;
    List<WebElement> centerNamesList;

    public CardComponent(WebDriver driver) {
        super(driver);
    }

//    public CardComponent(WebDriver driver, WebElement cardBody) {
//        super(driver);
//        cardBody = cardBody;
//    }


    public List<WebElement> getStarRatingZeroList() {
        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
        return cards.get(0).findElements(By.xpath(".//li[contains(@class, 'zero')]"));
    }

    public List<WebElement> getStarRatingFullList() {
        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
        return cards.get(0).findElements(By.xpath(".//li[contains(@class, 'full')]"));
    }

    public List<WebElement> getCardNamesList() {

      //  return driver.findElements(By.xpath(".//div[contains(@class, 'name')]"));
        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//div[contains(@class, 'name')]"));
    }

    public List<WebElement> getCenterNamesList() {
        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//div[contains(@class, 'center-name')]"));
    }

    public List<String> getUpperCaseTextFromWebElementsList(List<WebElement> webElementList) {
        List<String> elementsTextList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            elementsTextList.add(webElement.getText().toUpperCase());
        }
        return elementsTextList;
    }

}
