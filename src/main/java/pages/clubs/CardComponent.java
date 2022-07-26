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
    private ClubsPage clubsPage;

    public CardComponent(WebDriver driver) {
        super(driver);
    }

    public CardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        cardBody = cardBody;
    }

    public WebElement getCardName() {
        return driver.findElement(By.xpath(".//div[contains(@class, 'name')]"));
    }

    public String getTextCardName(WebElement element) {
        return element.getText();
    }


//    public List<WebElement> getStarRatingZeroList() {
//        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
//        return cards.get(0).findElements(By.xpath(".//li[contains(@class, 'zero')]"));
//    }
//
//    public List<WebElement> getStarRatingFullList() {
//        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
//        return cards.get(0).findElements(By.xpath(".//li[contains(@class, 'full')]"));
//    }

}
