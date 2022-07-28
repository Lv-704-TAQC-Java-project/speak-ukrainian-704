package pages.clubs.card.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlockCardComponent extends CardComponent {

    public BlockCardComponent(WebDriver driver) {
        super(driver);
    }

    public BlockCardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }
}
