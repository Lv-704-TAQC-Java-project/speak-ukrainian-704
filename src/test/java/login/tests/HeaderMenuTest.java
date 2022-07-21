package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClubsPage;

public class HeaderMenuTest extends BaseTest{
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
