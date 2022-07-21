package pages;

import org.openqa.selenium.*;
import pages.components.LoginModalComponent;


public class HomePage extends BasePage {
    private final String HOME_URL = BASE_URL;
    private WebElement profileMenu;
    private WebElement loginProfileMenuBtn;

    private WebElement clubsLinkBtn;
    private WebElement extendedSearchButton;

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


    public WebElement getClubsLinkBtn() {
        if (clubsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
            clubsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
        }
        return clubsLinkBtn;
    }

    public WebElement getExtendedSearchButton() {
        if (extendedSearchButton == null) {
            waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
            extendedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return extendedSearchButton;
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


    public WebElement getUserProfileBtn() {
        if (userProfileBtn == null) {
            waitVisibilityOfElement(By.xpath("//a[contains(@href, 'user')]"));
            userProfileBtn = driver.findElement(By.xpath("//a[contains(@href, 'user')]"));
        }
        return userProfileBtn;
    }

    public ProfilePage openUserProfilePage() {
        getUserProfileBtn().click();
        return new ProfilePage(driver);
    }

    public ClubsPage openClubsPage() {
        getClubsLinkBtn().click();
        return new ClubsPage(driver);
    }

    public ClubsPage clickExtendedSearchButton() {
        getExtendedSearchButton().click();
        return new ClubsPage(driver);
    }
}
