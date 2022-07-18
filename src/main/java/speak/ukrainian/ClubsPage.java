package speak.ukrainian;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClubsPage extends BasePage {
    List<WebElement> towns = driver.findElements(By.xpath("//li[contains(@class, 'ant-dropdown')]"));
    public ClubsPage() {
        PageFactory.initElements(driver, this);
    }
}
