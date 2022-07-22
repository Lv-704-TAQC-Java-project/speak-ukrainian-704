package pages.components;

import org.openqa.selenium.By;
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


    public LoginModalComponent(WebDriver driver) {
        super(driver);
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

    public WebElement getEmailFieldWrapper() {
        if (emailInputFieldWrapper == null) {
            waitBorderColorToChange();
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

    public WebElement getPasswordFieldWrapper() {
        if (passwordFieldWrapper == null) {
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

//        action.moveToElement(getLoginModal()).click();
        action.moveToElement(getLoginHeader()).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    public LoginModalComponent waitBorderColorToChange() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginModalComponent fillInEmail(String email) {
        getEmailInputField().sendKeys(email);
        return this;
    }

    public LoginModalComponent fillInPassword(String password) {
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
