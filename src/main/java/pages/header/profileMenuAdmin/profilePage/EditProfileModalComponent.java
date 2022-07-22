package pages.header.profileMenuAdmin.profilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class EditProfileModalComponent extends BasePage {

    private WebElement userButton;
    private WebElement managerButton;
    private WebElement lastNameInput;
    private WebElement firstNameInput;
    private WebElement phoneInput;
    private WebElement emailInput;
    private WebElement loadPhotoButton;
    private WebElement changePasswordCheckBox;
    private WebElement oldPasswordInput;
    private WebElement viewOldPasswordButton;
    private WebElement newPasswordInput;
    private WebElement viewNewPasswordButton;
    private WebElement repeatNewPasswordInput;
    private WebElement viewRepeatNewPasswordButton;
    private WebElement saveChangesButton;
    private WebElement closeButton;

    public EditProfileModalComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserButton() {
        if (userButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@value='ROLE_USER']/.."));
            userButton = driver.findElement(By.xpath("//input[@value='ROLE_USER']/.."));
        }
        return userButton;
    }

    public WebElement getManagerButton() {
        if (managerButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@value='ROLE_MANAGER']/.."));
            managerButton = driver.findElement(By.xpath("//input[@value='ROLE_MANAGER']/.."));
        }
        return managerButton;
    }

    public WebElement getLastNameInput() {
        if (lastNameInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_lastName']"));
            lastNameInput = driver.findElement(By.xpath("//input[@id='edit_lastName']"));
        }
        return lastNameInput;
    }

    public WebElement getFirstNameInput() {
        if (firstNameInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_firstName']"));
            firstNameInput = driver.findElement(By.xpath("//input[@id='edit_firstName']"));
        }
        return firstNameInput;
    }

    public WebElement getPhoneInput() {
        if (phoneInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_phone']"));
            phoneInput = driver.findElement(By.xpath("//input[@id='edit_phone']"));
        }
        return phoneInput;
    }

    public WebElement getEmailInput() {
        if (emailInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_email']"));
            emailInput = driver.findElement(By.xpath("//input[@id='edit_email']"));
        }
        return emailInput;
    }

    public WebElement getLoadPhotoButton() {
        if (loadPhotoButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_urlLogo']/following-sibling::span"));
            loadPhotoButton = driver.findElement(By.xpath("//input[@id='edit_urlLogo']/following-sibling::span"));
        }
        return loadPhotoButton;
    }

    public WebElement getChangePasswordCheckBox() {
        if (changePasswordCheckBox == null) {
            waitVisibilityOfElement(By.xpath("//input[@name='checkbox']"));
            changePasswordCheckBox = driver.findElement(By.xpath("//input[@name='checkbox']"));
        }
        return changePasswordCheckBox;
    }

    public WebElement getOldPasswordInput() {
        if (oldPasswordInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_currentPassword']"));
            oldPasswordInput = driver.findElement(By.xpath("//input[@id='edit_currentPassword']"));
        }
        return oldPasswordInput;
    }

    public WebElement getViewOldPasswordButton() {
        if (viewOldPasswordButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_currentPassword']/following-sibling::span"));
            viewOldPasswordButton = driver.findElement(By.xpath("//input[@id='edit_currentPassword']/following-sibling::span"));
        }
        return viewOldPasswordButton;
    }

    public WebElement getNewPasswordInput() {
        if (newPasswordInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_password']"));
            newPasswordInput = driver.findElement(By.xpath("//input[@id='edit_password']"));
        }
        return newPasswordInput;
    }

    public WebElement getViewNewPasswordButton() {
        if (viewNewPasswordButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_password']/following-sibling::span"));
            viewNewPasswordButton = driver.findElement(By.xpath("//input[@id='edit_password']/following-sibling::span"));
        }
        return viewNewPasswordButton;
    }

    public WebElement getRepeatNewPasswordInput() {
        if (repeatNewPasswordInput == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_confirmPassword']"));
            repeatNewPasswordInput = driver.findElement(By.xpath("//input[@id='edit_confirmPassword']"));
        }
        return repeatNewPasswordInput;
    }

    public WebElement getViewRepeatNewPasswordButton() {
        if (viewRepeatNewPasswordButton == null) {
            waitVisibilityOfElement(By.xpath("//input[@id='edit_confirmPassword']/following-sibling::span"));
            viewRepeatNewPasswordButton = driver.findElement(By.xpath("//input[@id='edit_confirmPassword']/following-sibling::span"));
        }
        return viewRepeatNewPasswordButton;
    }

    public WebElement getSaveChangesButton() {
        if (saveChangesButton == null) {
            waitVisibilityOfElement(By.xpath("//span[text()='Зберегти зміни']/.."));
            saveChangesButton = driver.findElement(By.xpath("//span[text()='Зберегти зміни']/.."));
        }
        return saveChangesButton;
    }

    public WebElement getCloseButton() {
        if (closeButton == null) {
            waitVisibilityOfElement(By.xpath("//button[@class='ant-modal-close']"));
            closeButton = driver.findElement(By.xpath("//button[@class='ant-modal-close']"));
        }
        return closeButton;
    }

    public EditProfileModalComponent userButtonClick() {
        getUserButton().click();
        return this;
    }

    public EditProfileModalComponent managerButtonClick() {
        getManagerButton().click();
        return this;
    }

    public EditProfileModalComponent fillInLastName(String lastName) {
        getLastNameInput().sendKeys(lastName);
        return this;
    }

    public EditProfileModalComponent fillInFirstName(String firstName) {
        getFirstNameInput().sendKeys(firstName);
        return this;
    }

    public EditProfileModalComponent fillInPhone(String phone) {
        getPhoneInput().sendKeys(phone);
        return this;
    }

    public EditProfileModalComponent fillInEmail(String email) {
        getEmailInput().sendKeys(email);
        return this;
    }

    public EditProfileModalComponent loadPhotoClick() {
        getLoadPhotoButton().click();
        return this;
    }

    public EditProfileModalComponent changePasswordClick() {
        getChangePasswordCheckBox().click();
        return this;
    }

    public EditProfileModalComponent inputOldPassword(String oldPassword) {
        getOldPasswordInput().sendKeys(oldPassword);
        return this;
    }

    public EditProfileModalComponent viewOldPasswordClick() {
        getViewOldPasswordButton().click();
        return this;
    }

    public EditProfileModalComponent inputNewPassword(String newPassword) {
        getNewPasswordInput().sendKeys(newPassword);
        return this;
    }

    public EditProfileModalComponent viewNewPasswordClick() {
        getViewNewPasswordButton().click();
        return this;
    }

    public EditProfileModalComponent inputNewPasswordRepeat(String newPasswordRepeat) {
        getRepeatNewPasswordInput().sendKeys(newPasswordRepeat);
        return this;
    }

    public EditProfileModalComponent viewNewPasswordRepeatClick() {
        getViewRepeatNewPasswordButton().click();
        return this;
    }

    public EditProfileModalComponent saveChangesClick() {
        getSaveChangesButton().click();
        return this;
    }

    public EditProfileModalComponent closeButtonClick() {
        getCloseButton().click();
        return this;
    }


}
