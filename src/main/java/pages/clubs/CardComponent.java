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
    private WebElement title;
    List<WebElement> starRatingZeroList;
    List<WebElement> starRatingFullList;
    List<WebElement> cardNamesList;
    private WebElement availableOnline;
    private List<WebElement> listOfCategoriesOnCard;
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
        return getCardName().getText();
    }

    public List<WebElement> getStarRatingZeroList() {
        return cardBody.findElements(By.xpath(".//li[contains(@class, 'zero')]"));
    }

    public List<WebElement> getStarRatingFullList() {
        return cardBody.findElements(By.xpath(".//li[contains(@class, 'full')]"));
    }

    public WebElement getTitle() {
        if (title == null) {
            waitVisibilityOfElement(By.xpath(".//div[@class='title']"), Duration.ofSeconds(5));
            title = cardBody.findElement(By.xpath(".//div[@class='title']"));
        }
        return title;
    }

    public ExpandedCardComponent cardTitleClick() {
        getTitle().click();
        return new ExpandedCardComponent(driver);
    }

    public WebElement getAvailableOnline() {
        if (availableOnline == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'club-online')]"), Duration.ofSeconds(2));
            availableOnline = cardBody.findElement(By.xpath("//div[contains(@class, 'club-online')]"));
        }
        return availableOnline;
    }

    public List<WebElement> getListOfCategoriesOnCard() {
        if (listOfCategoriesOnCard == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'card-body')]"), Duration.ofSeconds(2));
            listOfCategoriesOnCard = cardBody.findElements(By.xpath("//div[contains(@class, 'club-tags-box')]//span"));
        }
        return listOfCategoriesOnCard;
    }

    public boolean isClubAvailableOnline() {
        return getAvailableOnline().isDisplayed();
    }

}
