package pages.header.profileMenuAdmin.profilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.header.HeaderComponent;


public class ProfilePage extends BasePage {
    private HeaderComponent header;
    private WebElement currentUserEmailField;
    private WebElement editProfileButton;
    private WebElement pageIdentifier;
    private EditProfileModalComponent editProfileModalComponent;



    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
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

    public WebElement getPageIdentity(){
        if (pageIdentifier == null) {
            pageIdentifier = driver.findElement(By.xpath("//a[@href='/dev/about']"));
        }
        return pageIdentifier;
    }
}
