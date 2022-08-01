package login.tests;

import runners.BaseTestOneWindowRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.header.profileMenuGuest.LoginModalComponent;


public class LoginInputFieldsBorderTest extends BaseTestOneWindowRunner {

    @DataProvider(name = "loginInputFieldsBordersTestData")
    public Object[][] loginInputFieldsBordersTestData() {
        return new Object[][]{
                {"", "", true, true},
                {"some", "a", true, false},
                {configProps.getUserEmail(), configProps.getUserPassword(), false, false}
        };
    }

    @Test(dataProvider = "loginInputFieldsBordersTestData", priority = 1)
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

        loginModal.closeLoginModal();
    }
}
