package login.tests;

import runners.BaseTestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.header.profileMenuGuest.RegistrationModelComponent;

public class RegistrationTest extends BaseTestRunner {
    @DataProvider(name = "invalidDataRegistration")
    public Object[][] invalidNamesDataRegistration() {
        return new Object[][]{
                {"  ", "  ", "72540", "@qn.com", "1234", "123"},
        };
    }


    @Test(dataProvider = "invalidDataRegistration")
    public void invalidDataRegistration(String lastName, String name, String phone, String email, String password, String confirmPassword) {
        RegistrationModelComponent registrationComponent = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickRegistrationButton()
                .fillInLastName(lastName)
                .fillInName(name)
                .fillInPhone(phone)
                .fillInEmail(email)
                .fillInPassword(password)
                .fillInConfirmPassword(confirmPassword);
        String errorMessages = registrationComponent.getAllErrorMessages();
        SoftAssert softAssert = new SoftAssert();

        String invalidNameMessage = "Ім`я повинно починатися і закінчуватися літерою";
        String invalidLastNameMessage = "Прізвище повинно починатися і закінчуватися літерою";
        String invalidPhoneMessage = "Телефон не відповідає вказаному формату";
        String invalidEmailMessage = "Некоректний формат email";
        String invalidPasswordMessage = "Пароль повинен містити хоча б одну маленьку літеру";
        String invalidConfirmPasswordMessage = "Значення поля ‘Підтвердити пароль’ має бути еквівалентним значенню поля ‘Пароль’";



        softAssert.assertTrue(errorMessages.contains(invalidLastNameMessage), "Invalid error name message");
        softAssert.assertTrue(errorMessages.contains(invalidNameMessage), "Invalid error last name message");
        softAssert.assertTrue(errorMessages.contains(invalidPhoneMessage), "Invalid error phone message");
        softAssert.assertTrue(errorMessages.contains(invalidEmailMessage), "Invalid error email message");
        softAssert.assertTrue(errorMessages.contains(invalidPasswordMessage), "Invalid error password message");
        softAssert.assertTrue(errorMessages.contains(invalidConfirmPasswordMessage), "Invalid error confirm password message");



        softAssert.assertAll();
    }

}
