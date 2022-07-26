package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ClubPageComponent extends BasePage {

    private WebElement listCard;
    private WebElement blockCard;
    List<WebElement> starRatingZeroList;
    List<WebElement> starRatingFullList;
    List<WebElement> cardNamesList;
    List<WebElement> centerNamesList;


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

//    public List<WebElement> getStarRatingZeroList() {
//        WebElement cardBody = driver.findElement(By.xpath("//div[contains(@class, 'card-body')]"));
//        starRatingZeroList = cardBody.findElements(By.className("ant-rate-star ant-rate-star-zero"));
//        return starRatingZeroList;
//    }
//
//    public List<WebElement> getStarRatingFullList() {
//        WebElement cardBody = driver.findElement(By.xpath("//div[contains(@class, 'card-body')]"));
//        starRatingFullList = cardBody.findElements(By.className("ant-rate-star ant-rate-star-full"));
//        return starRatingFullList;
//    }

//    public List<WebElement> getStarRatingZeroList() {
//        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//li[contains(@class, 'zero')]"));
//    }
//
//    public List<WebElement> getStarRatingFullList() {
//        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//li[contains(@class, 'full')]"));
//    }

    public List<WebElement> getStarRatingZeroList() {
        return driver.findElements(By.xpath("//div[2]/div[1]//ul/li[@class = 'ant-rate-star ant-rate-star-zero']"));
    }

    public List<WebElement> getStarRatingFullList() {
        return driver.findElements(By.xpath("//div[2]/div[1]//ul/li[@class = 'ant-rate-star ant-rate-star-full']"));
    }

    public List<WebElement> getCardNamesList() {
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
