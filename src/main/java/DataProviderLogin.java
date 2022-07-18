import org.testng.annotations.DataProvider;

public class DataProviderLogin {

    @DataProvider(name = "validLoginAdmin")
    public static Object[][] validLoginAdmin() {
        return new Object[][]{
                {"admin@gmail.com", "admin"}
        };
    }

    @DataProvider(name = "loginAdminInvalidEmail")
    public static Object[][] loginAdminInvalidEmail() {
        return new Object[][]{
                {"admin123@gmail.com", "admin", "Введено невірний пароль або email"}
        };
    }
}
