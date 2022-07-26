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
        this.cardBody = cardBody;
    }

    public WebElement getCardName() {
        return cardBody.findElement(By.xpath(".//div[contains(@class, 'name')]"));
    }

    public String getTextCardName() {
        return getCardName().getText().toUpperCase();
    }


    public List<WebElement> getStarRatingZeroList() {
        return cardBody.findElements(By.xpath(".//li[contains(@class, 'zero')]"));
    }

    public List<WebElement> getStarRatingFullList() {
        return cardBody.findElements(By.xpath(".//li[contains(@class, 'full')]"));
    }

}
