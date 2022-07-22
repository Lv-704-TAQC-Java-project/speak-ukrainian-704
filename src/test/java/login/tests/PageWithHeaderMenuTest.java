package login.tests;

import org.testng.annotations.Test;
import pages.HomePage;


public class PageWithHeaderMenuTest extends BaseTestRunner {
    @Test
    public void checkHeaderMenuSwitching() {
        new HomePage(driver)
                .openClubsPage()
                .openAboutPage()
                .openNewsPage()
                .openAboutPage()
                .openServicePage()
                .openChallengeMenu();
    }
}
