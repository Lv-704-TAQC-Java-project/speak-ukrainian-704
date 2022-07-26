package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CenterComponent extends BasePage {

    private WebElement cardBody;
    private WebElement centerName;

    public CenterComponent(WebDriver driver) {
        super(driver);
    }

    public CenterComponent(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
    }

    public WebElement getCenterName() {
        if (centerName == null) {
            waitVisibilityOfElement(By.xpath(".//div[contains(@class, 'center-name')]"));
            centerName= cardBody.findElement(By.xpath(".//div[contains(@class, 'center-name')]"));
        }
        return centerName;
    }


}
