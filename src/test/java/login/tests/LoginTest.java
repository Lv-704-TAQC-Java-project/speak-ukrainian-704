package login.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProfilePage;


public class LoginTest extends BaseTest {

    @DataProvider (name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {validUserEmail, "a"},
                {"a@gmail.com", validUserPassword},
                {"a@gmail.com", "a"}
        };
    }

    @Test (dataProvider = "invalidLoginData")
    public void checkMistakeMessageIsShownAfterLoginWithInvalidData(String email, String password) {
        getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .checkLoginModalVisible()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm()
                .checkMistakeLoginMessageIsShown();
    }

    @DataProvider (name = "loginInputFieldsBordersTestData")
    public Object[][] loginInputFieldsBordersTestData() {
        return new Object[][]{
                {"", "", true, true},
                {"some", "a", true, false},
                {validUserEmail, validUserPassword, false, false}
        };
    }

    @Test (dataProvider = "loginInputFieldsBordersTestData")
    public void checkLoginInputFieldsBorders(String email, String password, boolean emailError, boolean passwordError) {
        getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .checkLoginModalVisible()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm()
                .checkEmailInputBorder(emailError)
                .checkPasswordInputBorder(passwordError);
    }

    @DataProvider (name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {validUserEmail, validUserPassword}
        };
    }

    @Test (dataProvider = "validLoginData")
    public void checkSuccessMessageIsShownAfterLogin(String email, String password) {
        getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .checkLoginModalVisible()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm()
                .checkSuccessLoginMessageIsShown();
    }

    @Test (dataProvider = "validLoginData")
    public void checkLoggedInUserEmailEqualsExpected(String email, String password) {
        ProfilePage profilePage = getHomePage()
                .openProfileMenu()
                .openLoginModal()
                .checkLoginModalVisible()
                .fillInEmail(email)
                .fillInPassword(password)
                .submitLoginForm()
                .waitForUserToBeLoggedIn()
                .openProfileMenu()
                .openUserProfilePage();

        profilePage.checkCurrentUserEmailEqualsExpected(email);
    }
}
