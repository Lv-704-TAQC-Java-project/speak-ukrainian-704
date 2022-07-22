package pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import pages.clubs.ClubsPage;
import pages.header.profileMenuAdmin.AdminProfileMenuComponent;
import pages.header.profileMenuGuest.GuestProfileMenuComponent;


public class HeaderComponent extends BasePage {
    private WebElement profileMenuButton;
    private GuestProfileMenuComponent guestProfileMenuComponent;
    private AdminProfileMenuComponent adminProfileMenuComponent;
    private PopupMessageComponent popupMessageComponent;
    private NavigationComponent navigationComponent;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    protected GuestProfileMenuComponent getGuestProfileMenuComponent() {
        if (guestProfileMenuComponent == null) {
            guestProfileMenuComponent = new GuestProfileMenuComponent(driver);
        }
        return guestProfileMenuComponent;
    }

    protected AdminProfileMenuComponent getAdminProfileMenuComponent() {
        if (adminProfileMenuComponent == null) {
            adminProfileMenuComponent = new AdminProfileMenuComponent(driver);
        }
        return adminProfileMenuComponent;
    }

    public WebElement getProfileMenuButton() {
        if (profileMenuButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'user-profile')]"));
            profileMenuButton = driver.findElement(By.xpath("//div[contains(@class, 'user-profile')]"));
        }
        return profileMenuButton;
    }

    public GuestProfileMenuComponent openGuestProfileMenu() {
        getProfileMenuButton().click();
        return getGuestProfileMenuComponent();
    }

    public AdminProfileMenuComponent openAdminProfileMenu() {
        getProfileMenuButton().click();
        return getAdminProfileMenuComponent();
    }

    public PopupMessageComponent getPopupMessageComponent() {
        if (popupMessageComponent == null) {
            popupMessageComponent = new PopupMessageComponent(driver);
        }
        return popupMessageComponent;
    }

    public WebElement getLoginErrorMessage() {
        return getPopupMessageComponent().getLoginErrorPopupMessage();
    }

    public WebElement getLoginSuccessMessage() {
        return getPopupMessageComponent().getLoginSuccessPopupMessage();
    }

    public NavigationComponent getNavigationComponent() {
        if (navigationComponent == null) {
            navigationComponent = new NavigationComponent(driver);
        }
        return navigationComponent;
    }

    public ClubsPage openClubsPage() {
        return getNavigationComponent().openClubsPage();
    }

    public HeaderComponent openChallengeMenu() {
        getNavigationComponent().openChallengeMenu();
        return this;
    }

    public NewsPage openNewsPage() {
        return getNavigationComponent().openNewsPage();
    }

    public ServicePage openServicePage() {
        return getNavigationComponent().openServicePage();
    }

    public AboutPage openAboutPage() {
        return getNavigationComponent().openAboutPage();
    }
}
