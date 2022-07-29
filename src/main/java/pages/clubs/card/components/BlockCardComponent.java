package pages.clubs.card.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlockCardComponent extends CardComponent {

    private WebElement blockCardContainer;

    public BlockCardComponent(WebDriver driver) {
        super(driver);
    }

    public BlockCardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }

    public WebElement getBlockCardContainer() {
        if (blockCardContainer == null) {
            blockCardContainer = driver.findElement(By.xpath("//div[@class = 'content-clubs-list content-clubs-block']"));
        }
        return blockCardContainer;
    }
}
