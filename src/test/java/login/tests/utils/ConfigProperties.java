package login.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private Properties prop;
    private String userEmail;
    private String userPassword;

    public ConfigProperties() {
        this.prop = new Properties();

        FileInputStream ip;
        try {
            ip = new FileInputStream("config.properties");
            prop.load(ip);
            setUserEmail(prop.getProperty("VALID_USER_EMAIL"));
            setUserPassword(prop.getProperty("VALID_USER_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }


}
