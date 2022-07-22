package login.tests;

import org.testng.annotations.Test;
import pages.HomePage;


public class PageWithHeaderMenuTest extends BaseTestRunner {
    @Test
    public void checkHeaderMenuSwitching() {
        new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .getHeader()
                .openAboutPage()
                .getHeader()
                .openNewsPage()
                .getHeader()
                .openAboutPage()
                .getHeader()
                .openServicePage()
                .getHeader()
                .openChallengeMenu();
    }
}
