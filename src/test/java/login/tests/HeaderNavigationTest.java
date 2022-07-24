package login.tests;

import login.tests.runners.BaseTestOneWindowRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import pages.clubs.ClubsPage;
import pages.header.NavigationComponent;


public class HeaderNavigationTest extends BaseTestOneWindowRunner {

    @Test (priority = 0)
    public void goToClubsPageLinkTest() {
        new HomePage(driver)
                .getHeader()
                .openClubsPage();

        String url = new ClubsPage(driver)
                .readCurrentUrl();

        WebElement clubsLinkWrapper = new NavigationComponent(driver)
                .getClubsLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");


        String clubsLinkBorderBottomColor = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom-color');", clubsLinkWrapper).toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clubsLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ClubsPageLink is not white.");
        softAssert.assertTrue(url.contains("clubs"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test (priority = 1)
    public void goToHomePageLinkTest() {
        new ClubsPage(driver)
                .getHeader()
                .openHomePage();

        String url = new HomePage(driver)
                .readCurrentUrl();

        WebElement clubsLinkWrapper = new NavigationComponent(driver)
                .getClubsLinkWrapperWithAttributeValue("border-bottom", "0px none rgb(0, 0, 0)");


        String clubsLinkBorderBottomValue = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom');", clubsLinkWrapper).toString();

        System.out.println();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clubsLinkBorderBottomValue.contains("0px none rgb(0, 0, 0)"), "Bottom border of ClubsPageLink is visible.");
        softAssert.assertTrue(url.equals(String.format("%s/", configProps.getBaseUrl())), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void goToChallengesPageLinkTest() {
        new HomePage(driver)
                .getHeader()
                .openChallengeMenu()
                .clickOnFirstChallengeFromList();

        String url = new ClubsPage(driver)
                .readCurrentUrl();

        WebElement challengesLinkWrapper = new NavigationComponent(driver)
                .getChallengesLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");


        String challengesLinkBorderBottomColor = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom-color');", challengesLinkWrapper).toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(challengesLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ChallengesPageLink is not white.");
        softAssert.assertTrue(url.contains("challenges"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test (priority = 3)
    public void goToNewsPageLinkTest() {
        new ChallengePage(driver)
                .getHeader()
                .openNewsPage();

        String url = new NewsPage(driver)
                .readCurrentUrl();

        WebElement newsLinkWrapper = new NavigationComponent(driver)
                .getNewsLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");


        String newsLinkBorderBottomColor = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom-color');", newsLinkWrapper).toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(newsLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of NewsPageLink is not white.");
        softAssert.assertTrue(url.contains("news"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test (priority = 4)
    public void goToAboutPageLinkTest() {
        new NewsPage(driver)
                .getHeader()
                .openAboutPage();

        String url = new AboutPage(driver)
                .readCurrentUrl();

        WebElement aboutLinkWrapper = new NavigationComponent(driver)
                .getAboutLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");


        String aboutLinkBorderBottomColor = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom-color');", aboutLinkWrapper).toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(aboutLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of AboutPageLink is not white.");
        softAssert.assertTrue(url.contains("about"), "Expected url is different from actual.");
        softAssert.assertAll();
    }

    @Test (priority = 5)
    public void goToServicePageLinkTest() {
        new AboutPage(driver)
                .getHeader()
                .openServicePage();

        String url = new ServicePage(driver)
                .readCurrentUrl();

        WebElement serviceLinkWrapper = new NavigationComponent(driver)
                .getServiceLinkWrapperWithAttributeValue("border-bottom-color", "rgb(255, 255, 255)");


        String serviceLinkBorderBottomColor = ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('border-bottom-color');", serviceLinkWrapper).toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(serviceLinkBorderBottomColor.contains("rgb(255, 255, 255)"), "Bottom border of ServicePageLink is not white.");
        softAssert.assertTrue(url.contains("service"), "Expected url is different from actual.");
        softAssert.assertAll();
    }
}
