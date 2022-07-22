package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class ClubPageComponent extends BasePage {

    List<WebElement> listOfCardsTypeList;
    List<WebElement> listOfCardsTypeBlock;

    public ClubPageComponent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfCardsTypeList() {
        listOfCardsTypeList = driver.findElements(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card list-rectangle-item']"));
        return listOfCardsTypeList;
    }

    public List<WebElement> getListOfCardsTypeBlock() {
        listOfCardsTypeList = driver.findElements(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card']"));
        return listOfCardsTypeList;
    }






}
