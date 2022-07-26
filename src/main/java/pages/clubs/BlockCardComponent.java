package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlockCardComponent extends CardComponent {

    private WebElement blockCard;

    public BlockCardComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getBlockCard() {
        if (blockCard == null) {
            blockCard = driver.findElement(By.xpath("//div[@class = 'content-clubs-list content-clubs-block']"));
            blockCard.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card']"));
        }
        return blockCard;
    }
}
