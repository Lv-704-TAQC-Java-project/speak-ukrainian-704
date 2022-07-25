package pages.header.profileMenuGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.HomePage;

public class LoginModalComponent extends BasePage {
    private WebElement loginModal;
    private WebElement emailInputField;
    private WebElement emailInputFieldWrapper;
    private WebElement passwordField;
    private WebElement passwordFieldWrapper;
    private WebElement submitLoginFormBtn;
    private WebElement loginHeader;
    private WebElement closeLoginModalButton;


    public LoginModalComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getCloseLoginModalButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'modal-close')]"));
    }

    public void closeLoginModal() {
        getCloseLoginModalButton().click();
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
            emailInputField = driver.findElement(By.xpath("//input[@id='basic_email']"));
        }
        return emailInputField;
    }

    public WebElement getEmailFieldWrapper(String color) {
        if (emailInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='basic_email']/parent::span"), "border-color", color);
            emailInputFieldWrapper = driver.findElement(By.xpath("//input[@id='basic_email']/parent::span"));
        }
        return emailInputFieldWrapper;
    }

    public WebElement getPasswordField() {
        if (passwordField == null) {
            passwordField = driver.findElement(By.xpath("//input[@id='basic_password']"));
        }
        return passwordField;
    }

    public WebElement getPasswordFieldWrapper(String color) {
        if (passwordFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='basic_password']/parent::span"), "border-color", color);
            passwordFieldWrapper = driver.findElement(By.xpath("//input[@id='basic_password']/parent::span"));
        }
        return passwordFieldWrapper;
    }

    public WebElement getSubmitLoginFormBtn() {
        if (submitLoginFormBtn == null) {
            submitLoginFormBtn = driver.findElement(By.xpath("//button[contains(@class, 'login-button')]"));
        }
        return submitLoginFormBtn;
    }

    public WebElement getLoginHeader() {
        if (loginHeader == null) {
            loginHeader = driver.findElement(By.xpath("//div[@class='login-header']"));
        }
        return loginHeader;
    }


    public LoginModalComponent clickOnLoginHeader() {
        Actions action = new Actions(driver);
        action.moveToElement(getLoginHeader()).click();
        return this;
    }

    public LoginModalComponent fillInEmail(String email) {
        getEmailInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getEmailInputField().sendKeys(email);
        return this;
    }

    public LoginModalComponent fillInPassword(String password) {
        getPasswordField().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginModalComponent clickLoginButton() {
        getSubmitLoginFormBtn().click();
        return this;
    }

    public LoginModalComponent waitForUserToBeLoggedIn() {
        waitForPageToReload();
        return this;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public HomePage getHomePageReload() {
        waitForPageToReload();
        return new HomePage(driver);
    }
}
