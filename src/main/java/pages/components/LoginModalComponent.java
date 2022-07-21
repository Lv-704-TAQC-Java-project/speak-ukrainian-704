package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;

public class LoginModalComponent extends BasePage {
    private WebElement loginModal;
    private WebElement emailInputField;
    private WebElement emailInputFieldWrapper;
    private WebElement passwordField;
    private WebElement passwordFieldWrapper;
    private WebElement submitLoginFormBtn;

    private WebElement loginSuccessPopupMessage;
    private WebElement loginErrorPopupMessage;

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

    public LoginModalComponent fillInEmail(String email) {
        getEmailInputField().sendKeys(email);
        return this;
    }

    public LoginModalComponent fillInPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginModalComponent submitLoginForm() {
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

}
