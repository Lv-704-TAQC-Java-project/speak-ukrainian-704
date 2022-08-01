package login.tests;

import runners.BaseTestOneWindowRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.header.profileMenuGuest.LoginModalComponent;


public class LoginInvalidDataTest extends BaseTestOneWindowRunner {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"a@gmail.com", "a"},
                {"a@gmail.com", configProps.getUserPassword()},
                {configProps.getUserEmail(), "a"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void checkMistakeMessageIsShownAfterLoginWithInvalidData(String email, String password) {
        LoginModalComponent loginModal = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();

        String errorMessageText = new HomePage(driver).getHeader().getLoginErrorMessage();
        Assert.assertTrue(errorMessageText.contains("невірний"), "Error message doesn't contain key word 'невірний'.");

        loginModal.closeLoginModal();
    }
}
