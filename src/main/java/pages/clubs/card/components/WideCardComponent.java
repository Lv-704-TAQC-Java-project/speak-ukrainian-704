package pages.clubs.card.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WideCardComponent extends CardComponent {

    private WebElement wideCardContainer;

    public WideCardComponent(WebDriver driver) {
        super(driver);
    }

    public WideCardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }

    public WebElement getWideCardContainer() {
        if (wideCardContainer == null) {
            wideCardContainer = driver.findElement(By.xpath("//div[@class = 'content-clubs-list false']"));
        }
        return wideCardContainer;
    }
}
