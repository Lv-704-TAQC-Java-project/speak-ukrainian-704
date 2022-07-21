package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.components.EditProfileModalComponent;
import pages.components.HeaderMenuListComponent;
import pages.components.LoginModalComponent;


public class ProfilePage extends BasePage {
    private WebElement currentUserEmailField;
    private WebElement editProfileButton;
    private EditProfileModalComponent editProfileModalComponent;



    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCurrentUserEmailField() {
        if (currentUserEmailField == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='user-email-data']"));
            currentUserEmailField = driver.findElement(By.xpath("//div[@class='user-email-data']"));
        }
        return currentUserEmailField;
    }

    public WebElement getEditProfileButton() {
        if (editProfileButton == null) {
            waitVisibilityOfElement(By.xpath("//button[contains(@class, 'ant-btn-text button')]"));
            editProfileButton = driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-text button')]"));
        }
        return editProfileButton;
    }

    public EditProfileModalComponent getEditProfileModalComponent() {
        if (editProfileModalComponent == null) {
            editProfileModalComponent = new EditProfileModalComponent(driver);
        }
        return editProfileModalComponent;
    }

    public EditProfileModalComponent clickEditProfileButton() {
        getEditProfileButton().click();
        return getEditProfileModalComponent();
    }

    public ClubsPage openClubsPage() {
        return new HeaderMenuListComponent(driver).openClubsPage();
    }

    public ProfilePage openChallengeMenu() {
        new HeaderMenuListComponent(driver).openChallengeMenu();
        return this;
    }

    public NewsPage openNewsPage() {
        return new HeaderMenuListComponent(driver).openNewsPage();
    }

    public ServicePage openServicePage() {
        return new HeaderMenuListComponent(driver).openServicePage();
    }

    public AboutPage openAboutPage() {
        return new HeaderMenuListComponent(driver).openAboutPage();
    }
}
