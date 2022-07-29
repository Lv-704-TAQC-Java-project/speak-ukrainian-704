package login.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.header.profileMenuAdmin.profilePage.EditProfileModalComponent;
import runners.BaseTestRunnerWithLogIn;

public class EditProfileFirstnameInputBordersTest extends BaseTestRunnerWithLogIn {
    @DataProvider(name = "editProfileFirstnameInputFieldsBordersTestData")
    public Object[][] firstnameInputFieldsBordersNegativeTestData() {
        return new Object[][]{
                {"00","0", true, "цифри"},
                {"@@","0", true, "спеціальні символи"},
                {"-", "0", true, "починатися і закінчуватися літерою"}
        };
    }
    @Test(dataProvider = "editProfileFirstnameInputFieldsBordersTestData")
    public void checkFirstnameInputBordersNegativeTest(String firstname,String phone, boolean lastnameError, String expectedError){
        EditProfileModalComponent editProfileModalComponent = new EditProfileModalComponent(driver);
        editProfileModalComponent.fillInFirstName(firstname).fillInPhone(phone);

        String expectedFirstnameBorderColor = lastnameError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";

        String getBorderColorOfFirstnameWrapper = editProfileModalComponent.getFirstNameFieldWrapper(expectedFirstnameBorderColor).getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfFirstnameWrapper.contains(expectedFirstnameBorderColor),
                String.format("Border color of firstname field border is expected to be %s, but was %s.",
                        expectedFirstnameBorderColor, getBorderColorOfFirstnameWrapper));
        softAssert.assertTrue(editProfileModalComponent.getFirstnameErrorText().contains(expectedError));
        softAssert.assertAll();

        editProfileModalComponent.closeButtonClick();
    }

    @DataProvider(name = "editProfileFirstnameInputFieldsBordersPositiveTestData")
    public Object[][] firstnameInputFieldsBordersPositiveTestData() {
        return new Object[][]{
                {"f", "0", false},
                {"gjhj", "0", false}
        };
    }

    @Test(dataProvider = "editProfileFirstnameInputFieldsBordersPositiveTestData")
    public void checkFirstnameInputBordersPositiveTest(String firstname,String phone, boolean lastnameError){
        EditProfileModalComponent editProfileModalComponent = new EditProfileModalComponent(driver);
        editProfileModalComponent.fillInFirstName(firstname).fillInPhone(phone);

        String expectedFirstnameBorderColor = lastnameError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";

        String getBorderColorOfFirstnameWrapper = editProfileModalComponent.getFirstNameFieldWrapper(expectedFirstnameBorderColor).getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfFirstnameWrapper.contains(expectedFirstnameBorderColor),
                String.format("Border color of firstname field border is expected to be %s, but was %s.",
                        expectedFirstnameBorderColor, getBorderColorOfFirstnameWrapper));

        softAssert.assertAll();

        editProfileModalComponent.closeButtonClick();
    }
}
