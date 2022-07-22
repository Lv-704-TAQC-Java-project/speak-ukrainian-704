package login.tests;

import org.testng.annotations.Test;


public class PageWithHeaderMenuTest extends BaseTestRunner {
    @Test
    public void checkHeaderMenuSwitching() {
                getHomePage()
                .openClubsPage()
                .openAboutPage()
                .openNewsPage()
                .openAboutPage()
                .openServicePage()
                .openChallengeMenu();
    }
}
