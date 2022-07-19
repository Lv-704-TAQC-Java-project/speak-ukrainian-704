import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String USER_1_EMAIL = readConfig().getString("users.validUser.email");
    String USER_1_PASSWORD = readConfig().getString("users.validUser.password");

    String USER_2_EMAIL = readConfig().getString("users.notValidUser.email");
    String USER_2_PASSWORD = readConfig().getString("users.notValidUser.password");

    
//    List<Integer> TOWNS = readConfig().getIntList(Arrays.toString("towns.numberOfClubs".split(" ")));

}
