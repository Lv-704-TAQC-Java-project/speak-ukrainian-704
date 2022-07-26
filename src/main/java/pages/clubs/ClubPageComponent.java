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
    List<WebElement> cardNamesList;
    private WebElement isClubAvailableOnline;
    private List<WebElement> listOfCards;
    private List<WebElement> listOfCategoriesOnCard;
    private WebElement titleOfCard;

    public ClubPageComponent(WebDriver driver) {
        super(driver);
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
            sleep(5);
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'card-body')]"), Duration.ofSeconds(5));
            listOfCards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
        }
        return listOfCards;
    }

    public WebElement getIsClubAvailableOnline(WebElement card) {
        waitVisibilityOfElement(By.xpath("//div[contains(@class, 'club-online')]"), Duration.ofSeconds(2));
        isClubAvailableOnline = card.findElement(By.xpath("//div[contains(@class, 'club-online')]"));
        return isClubAvailableOnline;
    }

    public List<WebElement> getListOfCategoriesOnCard(WebElement card) {
        if (listOfCategoriesOnCard == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'card-body')]"), Duration.ofSeconds(2));
            listOfCategoriesOnCard = card.findElements(By.xpath("//div[contains(@class, 'club-tags-box')]//span"));
        }
        return listOfCategoriesOnCard;
    }

    public WebElement getTitleOfCard(WebElement card) {
        sleep(5);
        waitVisibilityOfElement(By.xpath(".//div[@class='title']"), Duration.ofSeconds(5));
        return card.findElement(By.xpath(".//div[@class='title']"));
    }

    public ExpandedCardComponent titleOfCardClick(WebElement card) {
        sleep(5);
        waitElementIsClickable(getTitleOfCard(card));
        getTitleOfCard(card).click();
        return new ExpandedCardComponent(driver);
    }

    public boolean isCategoryAvailableOnCard(List<WebElement> cards, String nameOfCategory) {
        boolean isSectionAvailableOnCard = true;
        ExpandedCardComponent ex = new ExpandedCardComponent(driver);
//        List<WebElement> cards = getListOfCards();
        outer:
        for (WebElement card : cards) {
            titleOfCardClick(card);
            List<WebElement> listOfCategories = ex.getListOfCategories();
            for (WebElement category : listOfCategories) {
                String name = category.getText();
                if (!name.equals(nameOfCategory)) {
                    isSectionAvailableOnCard = false;
                } else {
                    ex.exitButtonClick();
                    continue outer;
                }
            }
            ex.exitButtonClick();
        }
        return isSectionAvailableOnCard;
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
