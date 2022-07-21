package login.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProfilePage;
import pages.components.LoginModalComponent;


public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {validUserEmail, "a"},
                {"a@gmail.com", validUserPassword},
                {"a@gmail.com", "a"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void checkMistakeMessageIsShownAfterLoginWithInvalidData(String email, String password) {
        LoginModalComponent loginModal = getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm();

        String errorMessageText = loginModal.getLoginErrorPopupMessage().getText();
        Assert.assertTrue(errorMessageText.contains("невірний"), "Error message doesn't contain key word 'невірний'.");
    }

    @DataProvider(name = "loginInputFieldsBordersTestData")
    public Object[][] loginInputFieldsBordersTestData() {
        return new Object[][]{
                {"", "", true, true},
                {"some", "a", true, false},
                {validUserEmail, validUserPassword, false, false}
        };
    }

    @Test(dataProvider = "loginInputFieldsBordersTestData")
    public void checkLoginInputFieldsBorders(String email, String password, boolean emailError, boolean passwordError) {
        LoginModalComponent loginModalComponent = getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm();

        String getCssClassOfEmailWrapper = loginModalComponent.getEmailInputFieldWrapper().getAttribute("class");
        String getCssClassOfPasswordWrapper = loginModalComponent.getPasswordFieldWrapper().getAttribute("class");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getCssClassOfEmailWrapper.contains(emailError ? "wrapper-status-error" : "wrapper-status-success"),
                "Wrapper class attribute doesn't contain expected class.");
        softAssert.assertTrue(getCssClassOfPasswordWrapper.contains(passwordError ? "wrapper-status-error" : "wrapper-status-success"),
                "Wrapper class attribute doesn't contain expected class.");
        softAssert.assertAll();
    }

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {validUserEmail, validUserPassword}
        };
    }

    @Test(dataProvider = "validLoginData")
    public void checkSuccessMessageIsShownAfterLogin(String email, String password) {
        LoginModalComponent loginModalComponent = getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm();

        String successMessageText = loginModalComponent.getLoginSuccessPopupMessage().getText();
        Assert.assertTrue(successMessageText.contains("успішно"), "Success message doesn't contain key word 'успішно'.");
    }

    @Test(dataProvider = "validLoginData")
    public void checkLoggedInUserEmailEqualsExpected(String email, String password) {
        ProfilePage profilePage = getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm()
                .waitForUserToBeLoggedIn()
                .getHomePage()
                .openProfileMenu()
                .openUserProfilePage();

        String userEmailOnProfilePage = profilePage.getCurrentUserEmailField().getText();
        Assert.assertEquals(email, userEmailOnProfilePage, "user email doesn't equal expected.");
    }
}
