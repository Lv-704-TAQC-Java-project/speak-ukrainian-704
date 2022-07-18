import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseMethods {

    @Test(dataProvider = "validLoginAdmin", dataProviderClass = DataProviderLogin.class)
    public void successfulLoginTestAdmin(String email, String password) {

        LoginPageElements elements = new LoginPageElements(driver);
        elements.clickUserIcon().clickEnterButton();
        elements.inputEmail(email).inputPassword(password);
        elements.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        elements.clickUserLogInIcon();
        elements.getUserProfileLink().isDisplayed();
    }

}
