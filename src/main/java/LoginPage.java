import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage extends BasePage{

    private WebElement userIcon;
    private WebElement userLogInIcon;
    private WebElement userProfileLink;
    private WebElement enterButton;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement invalidDataMessage;
    private WebElement validDataMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserIcon() {
        if (userIcon == null) {
            userIcon = driver.findElement(By.xpath("//div[@class = 'ant-dropdown-trigger user-profile']"));
        }
        return userIcon;
    }

    public WebElement getUserLogInIcon() {
        if (userLogInIcon == null) {
            userLogInIcon = driver.findElement(By.xpath("//div[2]/" +
                    "span[@class = 'ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']"));
        }
        return userLogInIcon;
    }

    public WebElement getUserProfileLink() {
        if (userProfileLink == null) {
            userProfileLink = driver.findElement(By.xpath("//div[2]/" +
                    "span[@class = 'ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']"));
        }
        return userProfileLink;
    }

    public WebElement getEnterButton() {
        if (enterButton == null) {
            enterButton = driver.findElement(By.xpath("//div/ul/li/span/div[text() = 'Увійти']"));
        }
        return enterButton;
    }

    public WebElement getEmailField() {
        if (emailField == null) {
            emailField = driver.findElement(By.xpath("//div/span/input[@id = 'basic_email']"));
        }
        return emailField;
    }

    public WebElement getPasswordField() {
        if (passwordField == null) {
            passwordField = driver.findElement(By.xpath("//div/span/input[@id = 'basic_password']"));
        }
        return passwordField;
    }

    public WebElement getLoginButton() {
        if (loginButton == null) {
            loginButton = driver.findElement(By.xpath("//div/button/span[text() = 'Увійти']"));
        }
        return loginButton;
    }

    public WebElement getInvalidDataMessage() {
        if (invalidDataMessage == null) {
            invalidDataMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний пароль')]"));
        }
        waitVisibilityOfElement(invalidDataMessage);
        return invalidDataMessage;
    }

    public WebElement getValidDataMessage() {
        if (validDataMessage == null) {
            validDataMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
        }
        waitVisibilityOfElement(validDataMessage);
        return validDataMessage;
    }

    public LoginPage clickUserIcon() {
        getUserIcon().click();
        return this;
    }

    public LoginPage clickEnterButton() {
        getEnterButton().click();
        return this;
    }

    public LoginPage inputEmail(String email) {
        getEmailField().click();
        getEmailField().clear();
        getEmailField().sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        getPasswordField().click();
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {

        getLoginButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return this;
    }

    public LoginPage clickUserLogInIcon() {
        getUserLogInIcon().click();
        return this;
    }


}
