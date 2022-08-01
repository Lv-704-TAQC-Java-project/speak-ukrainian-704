package header.tests;

import runners.BaseTestOneWindowRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import pages.clubs.ClubsPage;
import pages.header.HeaderComponent;
import pages.header.NavigationComponent;


public class HeaderNavigationTest extends BaseTestOneWindowRunner {

    @Test
    public void goToClubsPageLinkTest() {
        new HeaderComponent(driver)
                .openClubsPage();

        String url = new ClubsPage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement clubsLinkWrapper = navigation.getClubsLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");
        String clubsLinkBorderBottomColor = navigation.getPropertyValueOfPseudoElement(clubsLinkWrapper, ":after", "border-bottom-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clubsLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ClubsPageLink is not white.");
        softAssert.assertTrue(url.contains("clubs"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test
    public void goToHomePageLinkTest() {
        new HeaderComponent(driver)
                .openClubsPage()
                .getHeader()
                .openHomePage();

        String url = new HomePage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement clubsLinkWrapper = navigation.getClubsLinkWrapperWithAttributeValue("border-bottom", "0px none rgb(0, 0, 0)");
        String clubsLinkBorderBottomValue = navigation.getPropertyValueOfPseudoElement(clubsLinkWrapper, ":after", "border-bottom-color");

        System.out.println();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(clubsLinkBorderBottomValue.contains("0px none rgb(0, 0, 0)"), "Bottom border of ClubsPageLink is visible.");
        softAssert.assertTrue(url.equals(String.format("%s/", configProps.getBaseUrl())), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test
    public void goToChallengesPageLinkTest() {
        new HeaderComponent(driver)
                .openChallengeMenu()
                .clickOnFirstChallengeFromList();

        String url = new ClubsPage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement challengesLinkWrapper = navigation.getChallengesLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");
        String challengesLinkBorderBottomColor = navigation.getPropertyValueOfPseudoElement(challengesLinkWrapper, ":after", "border-bottom-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(challengesLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ChallengesPageLink is not white.");
        softAssert.assertTrue(url.contains("challenges"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test
    public void goToNewsPageLinkTest() {
        new HeaderComponent(driver)
                .openNewsPage();

        String url = new NewsPage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement newsLinkWrapper = navigation.getNewsLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");
        String newsLinkBorderBottomColor = navigation.getPropertyValueOfPseudoElement(newsLinkWrapper, ":after", "border-bottom-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(newsLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of NewsPageLink is not white.");
        softAssert.assertTrue(url.contains("news"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test
    public void goToAboutPageLinkTest() {
        new HeaderComponent(driver)
                .openAboutPage();

        String url = new AboutPage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement aboutLinkWrapper = navigation.getAboutLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");
        String aboutLinkBorderBottomColor = navigation.getPropertyValueOfPseudoElement(aboutLinkWrapper, ":after", "border-bottom-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(aboutLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of AboutPageLink is not white.");
        softAssert.assertTrue(url.contains("about"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test
    public void goToServicePageLinkTest() {
        new HeaderComponent(driver)
                .openServicePage();

        String url = new ServicePage(driver)
                .readCurrentUrl();

        NavigationComponent navigation = new NavigationComponent(driver);
        WebElement serviceLinkWrapper = navigation.getServiceLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");
        String serviceLinkBorderBottomColor = navigation.getPropertyValueOfPseudoElement(serviceLinkWrapper, ":after", "border-bottom-color");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(serviceLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ServicePageLink is not white.");
        softAssert.assertTrue(url.contains("service"), "Expected url is different from actual.");
        softAssert.assertAll();
    }
}
