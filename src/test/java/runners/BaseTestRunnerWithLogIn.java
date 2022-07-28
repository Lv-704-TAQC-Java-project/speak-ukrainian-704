package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTestRunnerWithLogIn extends BaseTestRunner{

    @BeforeMethod
    public void setUp(){
        super.setUp();
        HomePage homePage = new HomePage(driver);
                homePage.getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(configProps.getUserEmail())
                .fillInPassword(configProps.getUserPassword())
                .clickLoginButton();

        homePage.getHeader().getHomePageReload().openAdminProfileMenu().openUserProfilePage().clickEditProfileButton();
    }
}
