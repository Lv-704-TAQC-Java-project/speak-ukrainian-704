package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClubPageComponent extends BasePage {

    private WebElement listCard;
    private WebElement blockCard;
    private WebElement cardBody;
    private List<WebElement> cardNamesList;
    private List<WebElement> cardAddressesList;
    private WebElement isClubAvailableOnline;
    private List<WebElement> listOfCards;

    public ClubPageComponent(WebDriver driver) {
        super(driver);
    }

    public boolean clubsNotFoundMessageVisible() {
        return driver.findElement(By.xpath("//div[@class='clubs-not-found']")).isDisplayed();
    }

    public String clubsNotFoundMessage() {
        return driver.findElement(By.xpath("//div[@class='clubs-not-found']")).getText();
    }

    public List<WebElement> getCardAddressesList() {
        return driver.findElements(By.xpath("//span[@class='oneAddress']"));
    }

    public WebElement getListCard() {
        if (listCard == null) {
            listCard = driver.findElement(By.xpath("//div[@class = 'content-clubs-list false']"));
            listCard.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card list-rectangle-item']"));
        }
        return listCard;
    }

    public WebElement getBlockCard() {
        if (blockCard == null) {
            blockCard = driver.findElement(By.xpath("//div[@class = 'content-clubs-list content-clubs-block']"));
            blockCard.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card']"));
        }
        return blockCard;
    }

    public List<WebElement> getListOfCardNames() {
        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//div[contains(@class, 'name')]"));
    }

    public List<String> getUpperCaseTextFromWebElementsList(List<WebElement> webElementList) {
        List<String> elementsTextList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            elementsTextList.add(webElement.getText().toUpperCase());
        }
        return elementsTextList;
    }

    public List<WebElement> getListOfCards() {
        if (listOfCards == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'card-body')]"), Duration.ofSeconds(2));
            listOfCards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
        }
        return listOfCards;
    }

    public WebElement getIsClubAvailableOnline(WebElement card) {
        if (isClubAvailableOnline == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'club-online')]"), Duration.ofSeconds(2));
            isClubAvailableOnline = card.findElement(By.xpath("//div[contains(@class, 'club-online')]"));
        }
        return isClubAvailableOnline;
    }

    public boolean isAllClubsAvailableOnline(List<WebElement> cards) {
        boolean isOnline = true;
        for (WebElement card : cards) {
            if (!getIsClubAvailableOnline(card).isDisplayed()) {
                isOnline = false;
            }
        }
        return isOnline;
    }

}
