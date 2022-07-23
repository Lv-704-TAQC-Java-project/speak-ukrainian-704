package pages.header.profileMenuGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;

public class RegistrationModelComponent extends BasePage {
    private WebElement lastNameInputField;
    private WebElement lastNameInputFieldWrapper;

    private WebElement nameInputField;
    private WebElement nameInputFieldWrapper;

    private WebElement phoneInputField;
    private WebElement phoneFieldWrapper;

    private WebElement emailInputField;
    private WebElement emailInputFieldWrapper;

    private WebElement passwordInputField;
    private WebElement passwordInputFieldWrapper;

    private WebElement confirmPasswordInputField;
    private WebElement confirmPasswordInputFieldWrapper;

    private WebElement submitRegistrationFormBtn;

    public RegistrationModelComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLastNameInputField() {
        if (lastNameInputField == null) {
            lastNameInputField = driver.findElement(By.xpath("//input[@id='lastName']"));
        }
        return lastNameInputField;
    }

    public WebElement getLastNameInputFieldWrapper(String color) {
        if (lastNameInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='lastName']/parent::span"), "border-color", color);
            lastNameInputFieldWrapper = driver.findElement(By.xpath("//input[@id='lastName']/parent::span"));
        }
        return lastNameInputFieldWrapper;
    }

    public WebElement getNameInputField() {
        if (nameInputField == null) {
            nameInputField = driver.findElement(By.xpath("//input[@id='firstName']"));
        }
        return nameInputField;
    }

    public WebElement getNameInputFieldWrapper(String color) {
        if (nameInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='firstName']/parent::span"), "border-color", color);
            nameInputFieldWrapper = driver.findElement(By.xpath("//input[@id='firstName']/parent::span"));
        }
        return nameInputFieldWrapper;
    }

    public WebElement getPhoneInputField() {
        if (phoneInputField == null) {
            phoneInputField = driver.findElement(By.xpath("//input[@id='phone']"));
        }
        return phoneInputField;
    }

    public WebElement getPhoneFieldWrapper(String color) {
        if (phoneFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='phone']/parent::span"), "border-color", color);
            phoneFieldWrapper = driver.findElement(By.xpath("//input[@id='phone']/parent::span"));
        }
        return phoneFieldWrapper;
    }

    public WebElement getEmailInputField() {
        if (emailInputField == null) {
            emailInputField = driver.findElement(By.xpath("//input[@id='email']"));
        }
        return emailInputField;
    }

    public WebElement getEmailInputFieldWrapper(String color) {
        if (emailInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='email']/parent::span"), "border-color", color);
            emailInputFieldWrapper = driver.findElement(By.xpath("//input[@id='email']/parent::span"));
        }
        return emailInputFieldWrapper;
    }

    public WebElement getPasswordInputField() {
        if (passwordInputField == null) {
            passwordInputField = driver.findElement(By.xpath("//input[@id='password']"));
        }
        return passwordInputField;
    }

    public WebElement getPasswordInputFieldWrapper(String color) {
        if (passwordInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='password']/parent::span"), "border-color", color);
            passwordInputFieldWrapper = driver.findElement(By.xpath("//input[@id='password']/parent::span"));
        }
        return passwordInputFieldWrapper;
    }

    public WebElement getConfirmPasswordInputField() {
        if (confirmPasswordInputField == null) {
            confirmPasswordInputField = driver.findElement(By.xpath("//input[@id='confirm']"));
        }
        return confirmPasswordInputField;
    }

    public WebElement getConfirmPasswordInputFieldWrapper(String color) {
        if (confirmPasswordInputFieldWrapper == null) {
            waitAttributeOfElementContains(By.xpath("//input[@id='confirm']/parent::span"), "border-color", color);
            confirmPasswordInputFieldWrapper = driver.findElement(By.xpath("//input[@id='confirm']/parent::span"));
        }
        return confirmPasswordInputFieldWrapper;
    }

    public WebElement getSubmitRegistrationFormBtn() {
        if (submitRegistrationFormBtn == null) {
            submitRegistrationFormBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        }
        return submitRegistrationFormBtn;
    }

    public RegistrationModelComponent fillInLastName(String lastName){
        getLastNameInputField().sendKeys(lastName);
        return this;
    }

    public RegistrationModelComponent fillInName(String name){
        getNameInputField().sendKeys(name);
        return this;
    }

    public RegistrationModelComponent fillInPhone(String phone){
        getPhoneInputField().sendKeys(phone);
        return this;
    }

    public RegistrationModelComponent fillInEmail(String email){
        getEmailInputField().sendKeys(email);
        return this;
    }

    public RegistrationModelComponent fillInPassword(String password){
        getPasswordInputField().sendKeys(password);
        return this;
    }

    public RegistrationModelComponent fillInConfirmPassword(String confirmPassword){
        getConfirmPasswordInputField().sendKeys(confirmPassword);
        return this;
    }

    public RegistrationModelComponent clickSubmitRegistrationButton() {
        getSubmitRegistrationFormBtn().click();
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
