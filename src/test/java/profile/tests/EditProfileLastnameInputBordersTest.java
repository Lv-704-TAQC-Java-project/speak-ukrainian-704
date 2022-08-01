package profile.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.header.profileMenuAdmin.profilePage.EditProfileModalComponent;
import runners.BaseTestRunnerWithLogIn;

public class EditProfileLastnameInputBordersTest extends BaseTestRunnerWithLogIn {
    @DataProvider(name = "editProfileLastnameInputFieldsBordersTestData")
    public Object[][] lastnameInputFieldsBordersTestData() {
        return new Object[][]{
                {"00", "a", true, "цифри"},
                {"@@", "a", true, "спеціальні символи"},
                {"-", "a", true, "починатися і закінчуватися літерою"}
        };
    }
    @Test(dataProvider = "editProfileLastnameInputFieldsBordersTestData")
    public void checkLastnameInputBordersNegativeTest(String lastname,String firstname, boolean lastnameError, String expectedError){
        EditProfileModalComponent editProfileModalComponent = new EditProfileModalComponent(driver);
        editProfileModalComponent.fillInLastName(lastname).fillInFirstName(firstname);

        String expectedLastnameBorderColor = lastnameError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";

        String getBorderColorOfLastnameWrapper = editProfileModalComponent.getLastnameFieldWrapper(expectedLastnameBorderColor).getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfLastnameWrapper.contains(expectedLastnameBorderColor),
                String.format("Border color of lastname field border is expected to be %s, but was %s.",
                        expectedLastnameBorderColor, getBorderColorOfLastnameWrapper));
        softAssert.assertTrue(editProfileModalComponent.getLastnameErrorText().contains(expectedError));
            softAssert.assertAll();

        editProfileModalComponent.closeButtonClick();
    }

    @DataProvider(name = "editProfileFirstnameInputFieldsBordersTestData")
    public Object[][] firstnameInputFieldsBordersTestData() {
        return new Object[][]{
                {"f", "a", false},
                {"gjhj","a", false}
        };
    }

    @Test(dataProvider = "editProfileFirstnameInputFieldsBordersTestData")
    public void checkLastnameInputBordersPositiveTest(String lastname,String firstname, boolean lastnameError){
        EditProfileModalComponent editProfileModalComponent = new EditProfileModalComponent(driver);
        editProfileModalComponent.fillInLastName(lastname).fillInFirstName(firstname);

        String expectedLastnameBorderColor = lastnameError ? "rgb(255, 77, 79)" : "rgb(217, 217, 217)";

        String getBorderColorOfLastnameWrapper = editProfileModalComponent.getLastnameFieldWrapper(expectedLastnameBorderColor).getCssValue("border-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getBorderColorOfLastnameWrapper.contains(expectedLastnameBorderColor),
                String.format("Border color of lastname field border is expected to be %s, but was %s.",
                        expectedLastnameBorderColor, getBorderColorOfLastnameWrapper));

        softAssert.assertAll();

        editProfileModalComponent.closeButtonClick();
    }
}
