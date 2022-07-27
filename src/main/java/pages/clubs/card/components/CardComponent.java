package pages.clubs.card.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.clubs.ExpandedCardComponent;

import java.time.Duration;
import java.util.List;

public class CardComponent extends BasePage {

    protected WebElement cardBody;
    private WebElement cardTitle;
    protected WebElement cardName;
    protected WebElement address;
    protected List<WebElement> starRatingZeroList;
    protected List<WebElement> starRatingFullList;
    protected WebElement availableOnline;
    private List<WebElement> listOfCategoriesOnCard;


    public CardComponent(WebDriver driver) {
        super(driver);
    }

    public CardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }

    public WebElement getCardTitle() {
        if (cardTitle == null) {
            waitVisibilityOfElement(By.xpath(".//div[@class='title']"), Duration.ofSeconds(2));
            cardTitle = cardBody.findElement(By.xpath(".//div[@class='title']"));
        }
        return cardTitle;
    }

    public WebElement getCardName() {
        cardName = cardBody.findElement(By.xpath(".//div[contains(@class, 'name')]"));
        return cardName;
    }

    public WebElement getAddress() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        address = cardBody.findElement(By.xpath(".//div[@class='address']"));
        return address;
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
        availableOnline = cardBody.findElement(By.xpath("//div[contains(@class, 'club-online')]"));
        return availableOnline;
    }

    public List<WebElement> getListOfCategoriesOnCard() {
        if (listOfCategoriesOnCard == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'card-body')]"), Duration.ofSeconds(2));
            listOfCategoriesOnCard = cardBody.findElements(By.xpath("//div[contains(@class, 'club-tags-box')]//span"));
        }
        return listOfCategoriesOnCard;
    }

    public ExpandedCardComponent cardTitleClick() {
        getCardTitle().click();
        return new ExpandedCardComponent(driver);
    }

    public boolean isClubAvailableOnline() {
        return getAvailableOnline().isDisplayed();
    }

}
