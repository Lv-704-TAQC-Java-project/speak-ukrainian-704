import org.testng.Assert;
import org.testng.annotations.Test;
import speak.ukrainian.MainPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        MainPage mainPage = new MainPage();
        String msg = mainPage.successfulLogin(ConfigProvider.USER_1_EMAIL, ConfigProvider.USER_1_PASSWORD);
        Assert.assertEquals(msg, "Ви успішно залогувалися!");
    }

    @Test
    public void unsuccessfulLoginTest() {
        MainPage mainPage = new MainPage();
        String msg = mainPage.unsuccessfulLogin(ConfigProvider.USER_2_EMAIL, ConfigProvider.USER_2_PASSWORD);
        Assert.assertEquals(msg, "Введено невірний пароль або email");
    }
}
