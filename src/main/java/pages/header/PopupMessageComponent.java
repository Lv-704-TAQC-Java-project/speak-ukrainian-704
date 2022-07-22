package pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class PopupMessageComponent extends BasePage {

    private WebElement loginSuccessPopupMessage;
    private WebElement loginErrorPopupMessage;

    public PopupMessageComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginSuccessPopupMessage() {
        if (loginSuccessPopupMessage == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
            loginSuccessPopupMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
        }
        return loginSuccessPopupMessage;
    }

    public WebElement getLoginErrorPopupMessage() {
        if (loginErrorPopupMessage == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]"));
            loginErrorPopupMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]"));
        }
        return loginErrorPopupMessage;
    }
}
