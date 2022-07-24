package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.HomePage;
import pages.NewsPage;
import pages.ServicePage;
import pages.clubs.ClubsPage;
import pages.header.HeaderComponent;
import pages.header.NavigationComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PageWithHeaderMenuTest extends BaseTestRunner {
    @Test
    public void checkHeaderMenuSwitching() {

        Pattern pattern = Pattern.compile("\\w+\\z");
        ClubsPage clubsPage = new HomePage(driver)
                .getHeader()
                .openClubsPage();
        String clubsPageString = clubsPage.getPageIdentity().getAttribute("href");
        Matcher matcher = pattern.matcher(clubsPageString);
        if (matcher.find())
            clubsPageString = clubsPageString.substring(matcher.start());

        AboutPage aboutPage = clubsPage
                .getHeader()
                .openAboutPage();
        String aboutPageString = aboutPage.getPageIdentity().getAttribute("href");
        matcher = pattern.matcher(aboutPageString);
        if (matcher.find())
            aboutPageString = aboutPageString.substring(matcher.start());

        NewsPage newsPage = aboutPage
                .getHeader()
                .openNewsPage();
        String newsPageString = newsPage.getPageIdentity().getAttribute("href");
        matcher = pattern.matcher(newsPageString);
        if (matcher.find())
            newsPageString = newsPageString.substring(matcher.start());

        ServicePage servicePage = newsPage
                .getHeader()
                .openAboutPage()
                .getHeader()
                .openServicePage();
        String servicePageString = servicePage.getPageIdentity().getAttribute("href");
        matcher = pattern.matcher(servicePageString);
        if (matcher.find())
            servicePageString = servicePageString.substring(matcher.start());

        NavigationComponent header = servicePage
                .getHeader()
                .openChallengeMenu();
        Boolean challengeBoolean = header.getChallengeMenu().isDisplayed();

        Assert.assertEquals(clubsPageString,"clubs");
        Assert.assertEquals(aboutPageString,"about");
        Assert.assertEquals(newsPageString,"news");
        Assert.assertEquals(servicePageString,"service");
        Assert.assertTrue(challengeBoolean);
    }
}
