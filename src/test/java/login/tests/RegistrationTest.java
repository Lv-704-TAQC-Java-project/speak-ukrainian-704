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
                {"  ", "  ", "72540"},
        };
    }


    @Test(dataProvider = "invalidDataRegistration")
    public void invalidDataRegistration(String lastName, String name, String phone) {
        RegistrationModelComponent reg = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickRegistrationButton()
                .fillInLastName(lastName)
                .fillInName(name)
                .fillInPhone(phone);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SoftAssert softAssert = new SoftAssert();

        String invalidName = "Ім`я повинно починатися і закінчуватися літерою";
        String invalidLastName = "Прізвище повинно починатися і закінчуватися літерою";
        String invalidPhone = "Телефон не відповідає вказаному формату";


        softAssert.assertEquals(reg.getMessageInvalidLastName(), invalidLastName);
        softAssert.assertEquals(reg.getMessageInvalidName(), invalidName);
        softAssert.assertEquals(reg.getMessageInvalidPhoneFormat(), invalidPhone);


        softAssert.assertAll();
    }

}
