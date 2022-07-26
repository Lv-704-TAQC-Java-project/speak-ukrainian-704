package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WideCardComponent extends CardComponent {

    private WebElement listCard;

    public WideCardComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getListCard() {
        if (listCard == null) {
            listCard = driver.findElement(By.xpath("//div[@class = 'content-clubs-list false']"));
            listCard.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card list-rectangle-item']"));
        }
        return listCard;
    }
}
