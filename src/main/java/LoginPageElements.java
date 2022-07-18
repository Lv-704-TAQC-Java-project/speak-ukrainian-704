import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    WebDriver driver;
    private WebElement userIcon;
    private WebElement userLogInIcon;
    private WebElement userProfileLink;
    private WebElement advancedSearch;
    private WebElement enterButton;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement invalidDataMessage;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserIcon() {
        if (userIcon != null) {
            userIcon = driver.findElement(By.xpath("//div[@class = 'ant-dropdown-trigger user-profile']"));
        }
        return userIcon;
    }

    public WebElement getUserLogInIcon() {
        if (userLogInIcon != null) {
            userLogInIcon = driver.findElement(By.xpath("//div[2]/" +
                    "span[@class = 'ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']"));
        }
        return userLogInIcon;
    }

    public WebElement getUserProfileLink() {
        if (userProfileLink != null) {
            userProfileLink = driver.findElement(By.xpath("//div[2]/" +
                    "span[@class = 'ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']"));
        }
        return userProfileLink;
    }

    public WebElement getAdvancedSearch() {
        if (advancedSearch != null) {
            advancedSearch = driver.findElement(By.xpath("//div[@class = 'search-icon-group']/span[@class = 'anticon anticon-control advanced-icon']"));
        }
        return advancedSearch;
    }

    public WebElement getEnterButton() {
        if (enterButton != null) {
            enterButton = driver.findElement(By.xpath("//div/ul/li/span/div[text() = 'Увійти']"));
        }
        return enterButton;
    }

    public WebElement getEmailField() {
        if (emailField != null) {
            emailField = driver.findElement(By.xpath("//div/span/input[@id = 'basic_email']"));
        }
        return emailField;
    }

    public WebElement getPasswordField() {
        if (passwordField != null) {
            passwordField = driver.findElement(By.xpath("//div/span/input[@id = 'basic_password']"));
        }
        return passwordField;
    }

    public WebElement getLoginButton() {
        if (loginButton != null) {
            loginButton = driver.findElement(By.xpath("//div/button/span[text() = 'Увійти']"));
        }
        return loginButton;
    }

    public WebElement getInvalidDataMessage() {
        if (invalidDataMessage != null) {
            invalidDataMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний пароль')]"));
        }
        return invalidDataMessage;
    }

    public LoginPageElements clickUserIcon() {
        userIcon.click();
        return this;
    }

    public LoginPageElements clickEnterButton() {
        enterButton.click();
        return this;
    }

    public LoginPageElements inputEmail(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageElements inputPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPageElements clickLoginButton() {

        loginButton.click();
        return this;
    }

    public LoginPageElements clickUserLogInIcon() {
        userLogInIcon.click();
        return this;
    }


}
