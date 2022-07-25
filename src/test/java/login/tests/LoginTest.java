package login.tests;

import runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.header.profileMenuAdmin.profilePage.ProfilePage;
import pages.header.profileMenuGuest.LoginModalComponent;


public class LoginTest extends BaseTestRunner {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {configProps.getUserEmail(), "a"},
                {"a@gmail.com", configProps.getUserPassword()},
                {"a@gmail.com", "a"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void checkMistakeMessageIsShownAfterLoginWithInvalidData(String email, String password) {
        new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();

        String errorMessageText = new HomePage(driver).getHeader().getLoginErrorMessage().getText();
        Assert.assertTrue(errorMessageText.contains("невірний"), "Error message doesn't contain key word 'невірний'.");
    }

    @DataProvider(name = "loginInputFieldsBordersTestData")
    public Object[][] loginInputFieldsBordersTestData() {
        return new Object[][]{
                {"", "", true, true},
                {"some", "a", true, false},
                {configProps.getUserEmail(), configProps.getUserPassword(), false, false}
        };
    }

    @Test(dataProvider = "loginInputFieldsBordersTestData")
    public void checkLoginInputFieldsBorders(String email, String password, boolean emailError, boolean passwordError) {
        LoginModalComponent loginModal = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickOnLoginHeader()
                .clickLoginButton();

        String expectedEmailBorderColor = emailError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";
        String expectedPasswordBorderColor = passwordError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";

        String getBorderColorOfEmailWrapper = loginModal.getEmailFieldWrapper(expectedEmailBorderColor).getCssValue("border-color");
        String getBorderColorOfPasswordWrapper = loginModal.getPasswordFieldWrapper(expectedPasswordBorderColor).getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfEmailWrapper.contains(expectedEmailBorderColor),
                String.format("Border color of email field border is expected to be %s, but was %s.",
                        expectedEmailBorderColor, getBorderColorOfEmailWrapper));
        softAssert.assertTrue(getBorderColorOfPasswordWrapper.contains(expectedPasswordBorderColor),
                String.format("Border color of password field border is expected to be %s, but was %s.",
                        expectedPasswordBorderColor, getBorderColorOfPasswordWrapper));
        softAssert.assertAll();
    }

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
