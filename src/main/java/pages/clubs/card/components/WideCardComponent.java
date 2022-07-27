package pages.clubs.card.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WideCardComponent extends CardComponent {

    public WideCardComponent(WebDriver driver) {
        super(driver);
    }

    public WideCardComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }
}
