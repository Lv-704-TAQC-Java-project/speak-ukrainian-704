import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    WebDriver driver;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class = 'ant-dropdown-trigger user-profile']")
    private WebElement userIcon;

    public WebElement getUserIcon() {
        return userIcon;
    }

    @FindBy(how = How.XPATH, using = "//div[2]/" +
            "span[@class = 'ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']")
    private WebElement userLogInIcon;

    @FindBy(how = How.XPATH, using = "//li/span/a[text() = 'Мій Профіль ']")
    private WebElement userProfileLink;

    public WebElement getUserProfileLink() {
        return userProfileLink;
    }

    @FindBy(how = How.XPATH, using = "//div[@class = 'search-icon-group']/span[@class = 'anticon anticon-control advanced-icon']")
    private WebElement advancedSearch;

    public WebElement getAdvancedSearch() {
        return advancedSearch;
    }

    @FindBy(how = How.XPATH, using = "//div/ul/li/span/div[text() = 'Увійти']")
    private WebElement enterButton;

    public WebElement getEnterButton() {
        return enterButton;
    }

    @FindBy(how = How.XPATH, using =  "//div/span/input[@id = 'basic_email']")
    private WebElement emailField;

    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(how = How.XPATH, using =  "//div/span/input[@id = 'basic_password']")
    private WebElement passwordField;

    public WebElement getPasswordField() {
        return passwordField;
    }

    @FindBy(how = How.XPATH, using =  "//div/button/span[text() = 'Увійти']")
    private WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }

    @FindBy(how = How.XPATH, using =  "//div[@class='ant-message']//span[contains(text(), 'невірний пароль')]")
    private WebElement invalidDataMessage;

    public String getInvalidDataMessage() {
        return invalidDataMessage.getText();
    }

    public LoginPageElements clickUserIcon() {
        userIcon.click();
        return this;
    }

    public void clickEnterButton() {
       enterButton.click();
    }

    public LoginPageElements inputEmail(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public void inputPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickUserLogInIcon() {
        userLogInIcon.click();
    }







}
