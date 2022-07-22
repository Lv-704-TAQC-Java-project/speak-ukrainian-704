package login.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProfilePage;
import pages.components.LoginModalComponent;


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
                .openProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();

        String errorMessageText = new HomePage(driver).getLoginErrorMessage().getText();
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
                .openProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickOnLoginHeader()
                .clickLoginButton();

        String getBorderColorOfEmailWrapper = loginModal.getEmailFieldWrapper().getCssValue("border-color");
        String getBorderColorOfPasswordWrapper = loginModal.getPasswordFieldWrapper().getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfEmailWrapper.contains(emailError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)"),
                "Border color of email field wrapper is not of expected color.");
        softAssert.assertTrue(getBorderColorOfPasswordWrapper.contains(passwordError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)"),
                "Border color of password field wrapper is not of expected color.");
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
                .openProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();

        String successMessageText = new HomePage(driver).getLoginSuccessMessage().getText();
        Assert.assertTrue(successMessageText.contains("успішно"), "Success message doesn't contain key word 'успішно'.");
    }

    @Test(dataProvider = "validLoginData")
    public void checkLoggedInUserEmailEqualsExpected(String email, String password) {
        ProfilePage profilePage = new HomePage(driver)
                .openProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton()
                .getHomePageReload()
                .openProfileMenu()
                .openUserProfilePage();

        String userEmailOnProfilePage = profilePage.getCurrentUserEmailField().getText();
        Assert.assertEquals(email, userEmailOnProfilePage, "user email doesn't equal expected.");
    }
}
