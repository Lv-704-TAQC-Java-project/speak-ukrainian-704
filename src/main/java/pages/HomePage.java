package pages;

import org.openqa.selenium.*;
import org.testng.Assert;


public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL;
    private final String profileMenuPath = "//div[contains(@class, 'user-profile')]";
    private final String loginProfileMenuBtnPath = "//div[contains(text(), 'Увійти')]//ancestor::li";
    private final String loginModalPath = "//div[contains(@class, 'modal-login')]";
    private final String emailInputFieldPath = "//input[@id='basic_email']";
    private final String emailInputFieldErrorPath = emailInputFieldPath + "/parent::span";
    private final String passwordInputFieldPath = "//input[@id='basic_password']";
    private final String passwordInputFieldErrorPath = passwordInputFieldPath + "/parent::span";
    private final String submitLoginFormBtnPath = "//button[contains(@class, 'login-button')]";
    private final String userProfileBtnPath = "//a[contains(@href, 'user')]";
    private final String successLoginPopupMessagePath = "//div[@class='ant-message']//span[contains(text(), 'успішно')]";
    private final String mistakeLoginPopupMessagePath = "//div[@class='ant-message']//span[contains(text(), 'невірний')]";
    private final String clubsLinkPath = "//header//a[contains(@href, 'clubs')]";
    private final String extendedSearchButtonPath = "//span[contains(@class, 'anticon-control')]";


    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(HOME_URL);
        waitForPageToLoad();
    }

    public HomePage openProfileMenu() {
        WebElement profileMenu = driver.findElement(By.xpath(profileMenuPath));
        action.moveToElement(profileMenu).click().perform();
        return this;
    }

    public HomePage openLoginModal() {
        waitVisibilityOfElement(By.xpath(loginProfileMenuBtnPath));
        WebElement loginProfileMenuBtn = driver.findElement(By.xpath(loginProfileMenuBtnPath));
        action.moveToElement(loginProfileMenuBtn).click().perform();
        return this;
    }

    public HomePage checkLoginModalVisible() {
        waitVisibilityOfElement(By.xpath(loginModalPath));
        WebElement loginModal = driver.findElement(By.xpath(loginModalPath));
        Assert.assertTrue(loginModal.isDisplayed());
        return this;
    }

    public HomePage fillInEmail(String email) {
        waitVisibilityOfElement(By.xpath(emailInputFieldPath));
        WebElement emailField = driver.findElement(By.xpath(emailInputFieldPath));
        emailField.sendKeys(email);
        return this;
    }

    public HomePage fillInPassword(String password) {
        waitVisibilityOfElement(By.xpath(passwordInputFieldPath));
        WebElement passwordField = driver.findElement(By.xpath(passwordInputFieldPath));
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage submitLoginForm() {
        waitVisibilityOfElement(By.xpath(submitLoginFormBtnPath));
        WebElement submitLoginFormBtn = driver.findElement(By.xpath(submitLoginFormBtnPath));
        submitLoginFormBtn.click();
        return this;
    }

    public HomePage checkEmailInputBorder(boolean emailError) {
        WebElement emailInputFieldError = driver.findElement(By.xpath(emailInputFieldErrorPath));
        Assert.assertTrue(emailInputFieldError.getAttribute("class")
                .contains(emailError ? "wrapper-status-error" : "wrapper-status-success"));
        return this;
    }

    public HomePage checkPasswordInputBorder(boolean passwordError) {
        WebElement emailInputFieldError = driver.findElement(By.xpath(passwordInputFieldErrorPath));
        Assert.assertTrue(emailInputFieldError.getAttribute("class")
                .contains(passwordError ? "wrapper-status-error" : "wrapper-status-success"));
        return this;
    }

    public HomePage checkSuccessLoginMessageIsShown() {
        waitVisibilityOfElement(By.xpath(successLoginPopupMessagePath));
        WebElement successLoginPopupMessage = driver.findElement(By.xpath(successLoginPopupMessagePath));
        Assert.assertTrue(successLoginPopupMessage.getText().contains("успішно"));
        return this;
    }

    public HomePage checkMistakeLoginMessageIsShown() {
        waitVisibilityOfElement(By.xpath(mistakeLoginPopupMessagePath));
        WebElement mistakeLoginPopupMessage = driver.findElement(By.xpath(mistakeLoginPopupMessagePath));
        Assert.assertTrue(mistakeLoginPopupMessage.getText().contains("невірний"));
        return this;
    }

    public HomePage waitForUserToBeLoggedIn() {
        waitForPageToReload();
        return this;
    }

    public ProfilePage openUserProfilePage() {
        waitVisibilityOfElement(By.xpath(userProfileBtnPath));
        WebElement userProfileBtn = driver.findElement(By.xpath(userProfileBtnPath));
        userProfileBtn.click();
        return new ProfilePage(driver);
    }

    public ClubsPage openClubsPage() {
        waitVisibilityOfElement(By.xpath(clubsLinkPath));
        WebElement clubsLinkBtn = driver.findElement(By.xpath(clubsLinkPath));
        clubsLinkBtn.click();
        return new ClubsPage(driver);
    }

    public ClubsPage clickExtendedSearchButton() {
        waitVisibilityOfElement(By.xpath(extendedSearchButtonPath));
        WebElement extendedSearchButton = driver.findElement(By.xpath(extendedSearchButtonPath));
        action.moveToElement(extendedSearchButton).click().perform();
        return new ClubsPage(driver);
    }
}
