package pages;

import org.openqa.selenium.*;
import pages.components.HeaderMenuListComponent;
import pages.components.LogInProfileMenuComponent;
import pages.components.LoginModalComponent;


public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL;
    private WebElement profileMenu;
    private WebElement loginProfileMenuBtn;
    private WebElement advancedSearchButton;
    private WebElement userProfileBtn;
    private LoginModalComponent loginModalComponent;

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

    public WebElement getAdvancedSearchButton() {
        if (advancedSearchButton == null) {
            waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
            advancedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return advancedSearchButton;
    }

    public HomePage openProfileMenu() {
        getProfileMenu().click();
        return this;
    }

    public LoginModalComponent getLoginModalComponent() {
        if (loginModalComponent == null) {
            loginModalComponent = new LoginModalComponent(driver);
        }
        return loginModalComponent;
    }

    public LoginModalComponent openLoginModal() {
        getLoginProfileMenuBtn().click();
        return getLoginModalComponent();
    }

    public ProfilePage openUserProfilePage() {
        return new LogInProfileMenuComponent(driver).openUserProfilePage();
    }

    public ClubsPage clickAdvancedSearchButton() {
        getAdvancedSearchButton().click();
        return new ClubsPage(driver);
    }

    public ClubsPage openClubsPage() {
        return new HeaderMenuListComponent(driver).openClubsPage();
    }

    public HomePage openChallengeMenu() {
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
