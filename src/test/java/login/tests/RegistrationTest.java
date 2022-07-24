package login.tests;

import login.tests.runners.BaseTestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.header.profileMenuGuest.RegistrationModelComponent;

public class RegistrationTest extends BaseTestRunner {
    @DataProvider(name = "invalidDataRegistration")
    public Object[][] invalidNamesDataRegistration() {
        return new Object[][]{
                {"  ", "  ", "72540", "some", "password", "125pas"},
        };
    }


    @Test(dataProvider = "invalidDataRegistration")
    public void invalidDataRegistration(String lastName, String name, String phone, String email, String password, String confirmPassword) {
        RegistrationModelComponent reg = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickRegistrationButton()
                .fillInLastName(lastName)
                .fillInName(name)
                .fillInPhone(phone)
                .fillInEmail(email)
                .fillInPassword(password)
                .fillInConfirmPassword(confirmPassword);

        String expectedBorderColor = "rgb(255, 77, 79)";

        String getBorderColorOfLastNameWrapper = reg.getLastNameInputFieldWrapper(expectedBorderColor).getCssValue("border-color");
        String getBorderColorOfNameWrapper = reg.getNameInputFieldWrapper(expectedBorderColor).getCssValue("border-color");

        String getBorderColorOfPhoneWrapper = reg.getPhoneFieldWrapper(expectedBorderColor).getCssValue("border-color");
        String getBorderColorOfEmailWrapper = reg.getEmailInputFieldWrapper(expectedBorderColor).getCssValue("border-color");

        String getBorderColorOfPasswordWrapper = reg.getPasswordInputFieldWrapper(expectedBorderColor).getCssValue("border-color");
        String getBorderColorOfConfirmPasswordWrapper = reg.getConfirmPasswordInputFieldWrapper(expectedBorderColor).getCssValue("border-color");

        String mes = "Border color of email field border is expected to be %s, but was %s.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfLastNameWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfLastNameWrapper));
        softAssert.assertTrue(getBorderColorOfNameWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfNameWrapper));

        softAssert.assertTrue(getBorderColorOfPhoneWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfPhoneWrapper));
        softAssert.assertTrue(getBorderColorOfEmailWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfEmailWrapper));

        softAssert.assertTrue(getBorderColorOfPasswordWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfPasswordWrapper));
        softAssert.assertTrue(getBorderColorOfConfirmPasswordWrapper.contains(expectedBorderColor),
                String.format(mes,
                        expectedBorderColor, getBorderColorOfConfirmPasswordWrapper));

        softAssert.assertAll();
    }

}
