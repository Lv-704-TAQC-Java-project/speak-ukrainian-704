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
    private LocationComponent locationComponent;
    private WebElement imageUserComponent;
    private MapLocationComponent mapLocationComponent;
    private WebElement showOnMapButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LocationComponent getLocationComponent() {
        if (locationComponent == null) {
            locationComponent = new LocationComponent(driver);
        }
        return locationComponent;
    }
    public MapLocationComponent getMapLocationComponent() {
        if (mapLocationComponent == null) {
            mapLocationComponent = new MapLocationComponent(driver);
        }
        return mapLocationComponent;
    }
    public WebElement getShowOnMapButton() {
        if (showOnMapButton == null) {
            waitVisibilityOfElement(By.xpath("//span[contains(text(), 'Показати на мапі')]/parent::button"));
            showOnMapButton = driver.findElement(By.xpath("//span[contains(text(), 'Показати на мапі')]/parent::button"));
        }
        return showOnMapButton;
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

    public WebElement getUserIdentity(){
        if (imageUserComponent == null) {
            imageUserComponent = driver.findElement(By.xpath("//span[@aria-label='user']"));
        }
        return imageUserComponent;
    }

    public HeaderComponent getHomePageReload() {
        waitForPageToReload();
        return new HeaderComponent(driver);
    }

    public GuestProfileMenuComponent openGuestProfileMenu() {
        getProfileMenuButton().click();
        return getGuestProfileMenuComponent();
    }

    public AdminProfileMenuComponent openAdminProfileMenu() {
        getProfileMenuButton().click();
        return getAdminProfileMenuComponent();
    }
    public MapLocationComponent showOnMapButtonClick(){
        getShowOnMapButton().click();
        //sleep(1000);
        return new MapLocationComponent(driver);
    }
    public PopupMessageComponent getPopupMessageComponent() {
        if (popupMessageComponent == null) {
            popupMessageComponent = new PopupMessageComponent(driver);
        }
        return popupMessageComponent;
    }

    public String getLoginErrorMessage() {
        WebElement errorPopup = getPopupMessageComponent().getLoginErrorPopupMessage();
        String errorMessage = errorPopup.getText();
        waitInvisibilityOfElement(errorPopup);
        return errorMessage;
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

    public HomePage openHomePage() {
        return getNavigationComponent().openHomePage();
    }

    public ClubsPage openClubsPage() {
        return getNavigationComponent().openClubsPage();
    }

    public NavigationComponent openChallengeMenu() {
        getNavigationComponent().openChallengeMenu();
        return navigationComponent;
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
