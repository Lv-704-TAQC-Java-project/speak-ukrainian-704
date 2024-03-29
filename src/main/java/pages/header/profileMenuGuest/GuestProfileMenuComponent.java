package pages.header.profileMenuGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.header.profileMenuAdmin.profilePage.ProfilePage;

public class GuestProfileMenuComponent extends BasePage {
    private WebElement loginButton;
    private WebElement registrationButton;
    private WebElement myProfileButton;
    private WebElement menuIdentifier;

    private LoginModalComponent loginModal;

    private RegistrationModelComponent registrationModel;

    public GuestProfileMenuComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        if (loginButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
            loginButton = driver.findElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
        }
        return loginButton;
    }

    public WebElement getRegistrationButton() {
        if (registrationButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Зареєструватися')]//ancestor::li"));
            registrationButton = driver.findElement(By.xpath("//div[contains(text(), 'Зареєструватися')]//ancestor::li"));
        }
        return registrationButton;
    }

    public WebElement getMyProfileButton() {
        if (myProfileButton == null) {
            waitVisibilityOfElement(By.xpath("//a[contains(@href, 'user')]"));
            myProfileButton = driver.findElement(By.xpath("//a[contains(@href, 'user')]"));
        }
        return myProfileButton;
    }

    public LoginModalComponent getLoginModal() {
        if (loginModal == null) {
            loginModal = new LoginModalComponent(driver);
        }
        return loginModal;
    }

    public RegistrationModelComponent getRegistrationModal() {
        if (registrationModel == null) {
            registrationModel = new RegistrationModelComponent(driver);
        }
        return registrationModel;
    }

    public LoginModalComponent clickLoginButton() {
        getLoginButton().click();
        return getLoginModal();
    }

    public RegistrationModelComponent clickRegistrationButton(){
        getRegistrationButton().click();
        return getRegistrationModal();
    }

    public ProfilePage openUserProfilePage() {
        getMyProfileButton().click();
        return new ProfilePage(driver);
    }

}
