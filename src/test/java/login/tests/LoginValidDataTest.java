package login.tests;

import pages.header.profileMenuAdmin.profilePage.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import runners.BaseTestRunner;


public class LoginValidDataTest extends BaseTestRunner {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {configProps.getUserEmail(), configProps.getUserPassword()}
        };
    }

    @Test(dataProvider = "validLoginData")
    public void checkSuccessMessageIsShownAfterLogin(String email, String password) {
        new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();

        String successMessageText = new HomePage(driver).getHeader().getLoginSuccessMessage().getText();
        Assert.assertTrue(successMessageText.contains("успішно"), "Success message doesn't contain key word 'успішно'.");
    }

    @Test(dataProvider = "validLoginData")
    public void checkLoggedInUserEmailEqualsExpected(String email, String password) {
        ProfilePage profilePage = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton()
                .getHomePageReload()
                .getHeader()
                .openAdminProfileMenu()
                .openUserProfilePage();

        String userEmailOnProfilePage = profilePage.getCurrentUserEmailField().getText();
        Assert.assertEquals(email, userEmailOnProfilePage, "user email doesn't equal expected.");
    }
}
