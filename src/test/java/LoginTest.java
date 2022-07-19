import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import speak.ukrainian.MainPage;

public class LoginTest extends BaseTest {

    public MainPage getMainPage(){
        return new MainPage(BasePage.driver);
    }

    @Test
    public void successfulLoginTest() {
        String msg = getMainPage().successfulLogin(ConfigProvider.USER_1_EMAIL, ConfigProvider.USER_1_PASSWORD);
        Assert.assertEquals(msg, "Ви успішно залогувалися!");
    }

    @Test
    public void unsuccessfulLoginTest() {
        String msg = getMainPage().unsuccessfulLogin(ConfigProvider.USER_2_EMAIL, ConfigProvider.USER_2_PASSWORD);
        Assert.assertEquals(msg, "Введено невірний пароль або email");
    }
}
