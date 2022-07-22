package pages.header.profileMenuAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;
import pages.header.profileMenuAdmin.profilePage.ProfilePage;

public class AdminProfileMenuComponent extends BasePage {

    WebElement addGroupModal;
    WebElement addCenterModal;
    WebElement userProfileBtn;
    WebElement logOutBtn;
    WebElement administrationBtn;


    public AdminProfileMenuComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddGroupBtn() {
        if (addGroupModal == null) {
            waitVisibilityOfElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-active ant-dropdown-menu-item-only-child']"));
            addGroupModal = driver.findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-active ant-dropdown-menu-item-only-child']"));
        }
        return addGroupModal;
    }

    public WebElement getAddCenterBtn() {
        if (addCenterModal == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Додати центр')]//ancestor::li"));
            addCenterModal = driver.findElement(By.xpath("//div[contains(text(), 'Додати центр')]//ancestor::li"));
        }
        return addCenterModal;
    }

    public WebElement getUserProfileBtn() {
        if (userProfileBtn == null) {
            waitVisibilityOfElement(By.xpath("//a[contains(@href, 'user')]"));
            userProfileBtn = driver.findElement(By.xpath("//a[contains(@href, 'user')]"));
        }
        return userProfileBtn;
    }

    public WebElement getLogOutBtn() {
        if (logOutBtn == null) {
            waitVisibilityOfElement(By.xpath("//div[contains(text(), 'Вийти')]//ancestor::li"));
            logOutBtn = driver.findElement(By.xpath("//div[contains(text(), 'Вийти')]//ancestor::li"));
        }
        return logOutBtn;
    }

    public WebElement getAdministrationBtn() {
        if (administrationBtn == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-dropdown-menu-submenu-title']"));
            administrationBtn = driver.findElement(By.xpath("//div[@class='ant-dropdown-menu-submenu-title']"));
        }
        return administrationBtn;
    }

    public AddGroupModalComponent openAddGroupModal() {
        getAddGroupBtn().click();
        return new AddGroupModalComponent(driver);
    }

    public AddCenterModalComponent openAddCenterModal() {
        getAddCenterBtn().click();
        return new AddCenterModalComponent(driver);
    }

    public ProfilePage openUserProfilePage() {
        getUserProfileBtn().click();
        return new ProfilePage(driver);
    }

    public HomePage clickLogOutBtn() {
        getLogOutBtn().click();
        return new HomePage(driver);
    }

    public AdministrationModalComponent openAdministrationModal() {
        getAdministrationBtn().click();
        return new AdministrationModalComponent(driver);
    }

}
