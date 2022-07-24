package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.HomePage;
import pages.NewsPage;
import pages.ServicePage;
import pages.clubs.ClubsPage;
import pages.header.HeaderComponent;

public class PageWithHeaderMenuTest extends BaseTestRunner {
    @Test
    public void checkHeaderMenuSwitching() {

        ClubsPage clubsPage = new HomePage(driver)
                .getHeader()
                .openClubsPage();
        boolean clubsTrue = clubsPage.getPageIdentity();

        AboutPage aboutPage = clubsPage
                .getHeader()
                .openAboutPage();
        boolean aboutTrue = aboutPage.getPageIdentity();

        NewsPage newsPage = aboutPage
                .getHeader()
                .openNewsPage();
        boolean newsTrue = newsPage.getPageIdentity();

        ServicePage servicePage = newsPage
                .getHeader()
                .openAboutPage()
                .getHeader()
                .openServicePage();
        boolean serviceTrue = servicePage.getPageIdentity();

        HeaderComponent header = servicePage
                .getHeader()
                .openChallengeMenu();
        boolean challengeBoolean = header.getNavigationComponent().getChallengeMenu().isDisplayed();

        Assert.assertTrue(clubsTrue);
        Assert.assertTrue(aboutTrue);
        Assert.assertTrue(newsTrue);
        Assert.assertTrue(serviceTrue);
        Assert.assertTrue(challengeBoolean);
    }
}
