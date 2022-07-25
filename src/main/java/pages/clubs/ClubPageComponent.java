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
    private WebElement cardBody;
    List<WebElement> cardNamesList;


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
        waitVisibilityOfElements(By.xpath("//div[contains(@class, 'card-body')]//div[contains(@class, 'name')]"));
        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]//div[contains(@class, 'name')]"));
    }

    public List<String> getUpperCaseTextFromWebElementsList(List<WebElement> webElementList) {
        List<String> elementsTextList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            elementsTextList.add(webElement.getText().toUpperCase());
        }
        return elementsTextList;
    }

}
