import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithInvalidDataTest extends BaseMethods {

    @Test(dataProvider = "loginAdminInvalidEmail", dataProviderClass = DataProviderLogin.class)
    public void loginTestAdminInvalidEmail(String email, String password, String expectedMessage) {
        LoginPageElements elements = new LoginPageElements(driver);
        elements.clickUserIcon().clickEnterButton();
        elements.inputEmail(email).inputPassword(password);
        elements.clickLoginButton();
        String actual = elements.getInvalidDataMessage().getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
