import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataProviderLogin {

    @DataProvider(name = "validLoginAdmin")
    public static Object[][] validLoginAdmin() {
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("/Users/myroslavavynokur/ATQC_Course/speak-ukrainian-704/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[][]{
                {prop.getProperty("email"), prop.getProperty("password"), "Ви успішно залогувалися!"}
        };
    }

    @DataProvider(name = "loginAdminInvalidEmail")
    public static Object[][] loginAdminInvalidEmail() {
        return new Object[][]{
                {"admin123@gmail.com", "admin", "Введено невірний пароль або email"}
        };
    }
}
