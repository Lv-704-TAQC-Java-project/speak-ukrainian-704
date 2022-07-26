package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CardComponent extends BasePage {

    private WebElement cardBody;
    private WebElement cardName;
    List<WebElement> starRatingZeroList;
    List<WebElement> starRatingFullList;
    private WebElement availableOnline;
    
    public CardComponent(WebDriver driver) {
        super(driver);
    }

    public CardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }

    public WebElement getCardName() {
        if (cardName == null) {
            waitVisibilityOfElement(By.xpath(".//div[contains(@class, 'name')]"));
            cardName = cardBody.findElement(By.xpath(".//div[contains(@class, 'name')]"));
        }
        return cardName;
    }

    public String getTextCardName() {
        return getCardName().getText();
    }

    public List<WebElement> getStarRatingZeroList() {
        if (starRatingZeroList == null) {
            waitVisibilityOfElements(cardBody.findElements(By.xpath(".//li[contains(@class, 'zero')]")));
            starRatingZeroList = cardBody.findElements(By.xpath(".//li[contains(@class, 'zero')]"));
        }
        return starRatingZeroList;
    }

    public List<WebElement> getStarRatingFullList() {
        if (starRatingFullList == null) {
            waitVisibilityOfElements(cardBody.findElements(By.xpath(".//li[contains(@class, 'full')]")));
            starRatingFullList = cardBody.findElements(By.xpath(".//li[contains(@class, 'full')]"));
        }
        return starRatingFullList;
    }

    public WebElement getAvailableOnline() {
        if (availableOnline == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'club-online')]"), Duration.ofSeconds(2));
            availableOnline = cardBody.findElement(By.xpath("//div[contains(@class, 'club-online')]"));
        }
        return availableOnline;
    }

    public boolean isClubAvailableOnline() {
        return getAvailableOnline().isDisplayed();
    }

}
