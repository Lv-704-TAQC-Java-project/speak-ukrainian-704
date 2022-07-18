import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseMethods {

    @Test(dataProvider = "validLoginAdmin", dataProviderClass = DataProviderLogin.class)
    public void successfulLoginTestAdmin(String email, String password, String expectedMessage) {
        LoginPage elements = new LoginPage(driver);
        getHomepage();
        elements.clickUserIcon().clickEnterButton().inputEmail(email).inputPassword(password)
                .clickLoginButton();
        String actual = elements.getValidDataMessage().getText();
        elements.clickUserLogInIcon().getUserProfileLink().isDisplayed();
        Assert.assertEquals(actual, expectedMessage);
    }

    @Test(dataProvider = "loginAdminInvalidEmail", dataProviderClass = DataProviderLogin.class)
    public void loginTestAdminInvalidEmail(String email, String password, String expectedMessage) {
        getHomepage();
        LoginPage elements = new LoginPage(driver);
        elements.clickUserIcon().clickEnterButton().inputEmail(email).inputPassword(password).clickLoginButton();
        String actual = elements.getInvalidDataMessage().getText();
        Assert.assertEquals(actual, expectedMessage);
    }

}
