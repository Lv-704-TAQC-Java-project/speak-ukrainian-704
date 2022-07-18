import org.testng.annotations.Test;

public class LoginElementsIsDisplayedTest extends BaseMethods {

    @Test(priority = 1)
    public void searchElementIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
       elements.getAdvancedSearch().isDisplayed();
    }

    @Test (priority = 2)
    public void userIconElementIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
        //elements.getUserIcon().isDisplayed();
    }

    @Test (priority = 3)
    public void enterElementIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
        elements.clickUserIcon();
        elements.getEnterButton().isDisplayed();
    }

    @Test (priority = 4)
    public void emailFieldIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
        elements.clickEnterButton();
        elements.getEmailField().isDisplayed();
    }

    @Test (priority = 5)
    public void passwordFieldIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
        elements.getPasswordField().isDisplayed();
    }

    @Test (priority = 6)
    public void loginButtonIsDisplayed() {
        LoginPageElements elements = new LoginPageElements(driver);
        elements.getLoginButton().isDisplayed();
    }

}