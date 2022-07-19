package pages;

import org.openqa.selenium.*;


public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL;
    private WebElement profileMenu;
    private WebElement loginProfileMenuBtn;
    private WebElement loginModal;
    private WebElement emailInputField;
    private WebElement emailInputFieldWrapper;
    private WebElement passwordField;
    private WebElement passwordFieldWrapper;
    private WebElement submitLoginFormBtn;
    private WebElement userProfileBtn;
    private WebElement successLoginPopupMessage;
    private WebElement mistakeLoginPopupMessage;
    private WebElement clubsLinkBtn;
    private WebElement extendedSearchButton;


    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(HOME_URL);
        waitForPageToLoad();
    }

    public WebElement getProfileMenu() {
        profileMenu = driver.findElement(By.xpath("//div[contains(@class, 'user-profile')]"));
        return profileMenu;
    }

    public WebElement getLoginProfileMenuBtn() {
        if (loginProfileMenuBtn == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
            loginProfileMenuBtn = driver.findElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
        }
        return loginProfileMenuBtn;
    }

    public WebElement getLoginModal() {
        if (loginModal == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'modal-login')]"));
            loginModal = driver.findElement(By.xpath("//div[contains(@class, 'modal-login')]"));
        }
        return loginModal;
    }

    public WebElement getEmailInputField() {
        if (emailInputField == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='basic_email']"));
            emailInputField = driver.findElement(By.xpath("//input[@id='basic_email']"));
        }
        return emailInputField;
    }

    public WebElement getEmailInputFieldWrapper() {
        if (emailInputFieldWrapper == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='basic_email']/parent::span"));
            emailInputFieldWrapper = driver.findElement(By.xpath("//input[@id='basic_email']/parent::span"));
        }
        return emailInputFieldWrapper;
    }

    public WebElement getPasswordField() {
        if (passwordField == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='basic_password']"));
            passwordField = driver.findElement(By.xpath("//input[@id='basic_password']"));
        }
        return passwordField;
    }

    public WebElement getPasswordFieldWrapper() {
        if (passwordFieldWrapper == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='basic_password']/parent::span"));
            passwordFieldWrapper = driver.findElement(By.xpath("//input[@id='basic_password']/parent::span"));
        }
        return passwordFieldWrapper;
    }

    public WebElement getSubmitLoginFormBtn() {
        if (submitLoginFormBtn == null) {
            waitVisibilityOfElement(By.xpath("//button[contains(@class, 'login-button')]"));
            submitLoginFormBtn = driver.findElement(By.xpath("//button[contains(@class, 'login-button')]"));
        }
        return submitLoginFormBtn;
    }

    public WebElement getUserProfileBtn() {
        if (userProfileBtn == null) {
            waitVisibilityOfElement(By.xpath("//a[contains(@href, 'user')]"));
            userProfileBtn = driver.findElement(By.xpath("//a[contains(@href, 'user')]"));
        }
        return userProfileBtn;
    }

    public WebElement getSuccessLoginPopupMessage() {
        if (successLoginPopupMessage == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
            successLoginPopupMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
        }
        return successLoginPopupMessage;
    }

    public WebElement getMistakeLoginPopupMessage() {
        if (mistakeLoginPopupMessage == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]"));
            mistakeLoginPopupMessage = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]"));
        }
        return mistakeLoginPopupMessage;
    }

    public WebElement getClubsLinkBtn() {
        if (clubsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
            clubsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
        }
        return clubsLinkBtn;
    }

    public WebElement getExtendedSearchButton() {
        if (extendedSearchButton == null) {
            waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
            extendedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return extendedSearchButton;
    }

    public HomePage openProfileMenu() {
        getProfileMenu().click();
        return this;
    }

    public HomePage openLoginModal() {
        getLoginProfileMenuBtn().click();
        return this;
    }

    public HomePage fillInEmail(String email) {
        getEmailInputField().sendKeys(email);
        return this;
    }

    public HomePage fillInPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public HomePage submitLoginForm() {
        getSubmitLoginFormBtn().click();
        return this;
    }

    public HomePage waitForUserToBeLoggedIn() {
        waitForPageToReload();
        return this;
    }

    public ProfilePage openUserProfilePage() {
        getUserProfileBtn().click();
        return new ProfilePage(driver);
    }

    public ClubsPage openClubsPage() {
        getClubsLinkBtn().click();
        return new ClubsPage(driver);
    }

    public ClubsPage clickExtendedSearchButton() {
        getExtendedSearchButton().click();
        return new ClubsPage(driver);
    }
}
