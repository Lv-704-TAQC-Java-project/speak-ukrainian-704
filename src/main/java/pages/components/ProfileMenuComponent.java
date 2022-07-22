package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;
import pages.ProfilePage;

public class ProfileMenuComponent extends BaseMethods {
    private WebElement loginButton;
    private WebElement registerButton;
    private WebElement myProfileButton;

    private LoginModalComponent loginModal;

    public ProfileMenuComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        if (loginButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
            loginButton = driver.findElement(By.xpath("//div[contains(text(), 'Увійти')]//ancestor::li"));
        }
        return loginButton;
    }

    public WebElement getRegisterButton() {
        if (registerButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Зареєструватися')]//ancestor::li"));
            registerButton = driver.findElement(By.xpath("//div[contains(text(), 'Зареєструватися')]//ancestor::li"));
        }
        return registerButton;
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

    public LoginModalComponent clickLoginButton() {
        getLoginButton().click();
        return getLoginModal();
    }

    public ProfilePage openUserProfilePage() {
        getMyProfileButton().click();
        return new ProfilePage(driver);
    }
}
