package pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import pages.components.PopupMessageComponent;
import pages.components.ProfileMenuComponent;
import pages.components.NavigationComponent;


public class HeaderComponent extends BasePage {
    private WebElement profileMenuButton;
    private ProfileMenuComponent profileMenuComponent;
    private PopupMessageComponent popupMessageComponent;
    private NavigationComponent navigationComponent;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    protected ProfileMenuComponent getProfileMenuComponent() {
        if (profileMenuComponent == null) {
            profileMenuComponent = new ProfileMenuComponent(driver);
        }
        return profileMenuComponent;
    }

    public WebElement getProfileMenuButton() {
        if (profileMenuButton == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(@class, 'user-profile')]"));
            profileMenuButton = driver.findElement(By.xpath("//div[contains(@class, 'user-profile')]"));
        }
        return profileMenuButton;
    }

    public ProfileMenuComponent openProfileMenu() {
        getProfileMenuButton().click();
        return getProfileMenuComponent();
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
