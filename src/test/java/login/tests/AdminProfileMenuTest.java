package login.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.header.HeaderComponent;
import pages.header.profileMenuAdmin.AddCenterModalComponent;
import pages.header.profileMenuAdmin.AddGroupModalComponent;
import pages.header.profileMenuAdmin.profilePage.ProfilePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdminProfileMenuTest extends BaseTestRunner {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {configProps.getUserEmail(), configProps.getUserPassword()}
        };
    }

    @Test(dataProvider = "validLoginData")
    public void checkAdminProfileMenu(String email, String password) {
        AddGroupModalComponent componentGroup =new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .clickLoginButton()
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton()
                .getHomePageReload()
                .getHeader()
                .openAdminProfileMenu()
                .openAddGroupModal();
        String headerGroup = componentGroup.getGroupHeader().getText();

        AddCenterModalComponent componentCenter = componentGroup
                .clickOnCloseGroupBtn()
                .openAdminProfileMenu()
                .openAddCenterModal();
        String headerCenter = componentCenter.getCenterHeader().getText();

        ProfilePage profilePage = componentCenter
                .clickOnCloseCenterBtn()
                .openAdminProfileMenu()
                .openUserProfilePage();
        Pattern pattern = Pattern.compile("\\w+\\z");
        String hrefProfilePage = profilePage.getPageIdentity().getAttribute("href");
        Matcher matcher = pattern.matcher(hrefProfilePage);
        if (matcher.find())
            hrefProfilePage = hrefProfilePage.substring(matcher.start());

        HeaderComponent home = profilePage
                .getHeader()
                .getHomePageReload()
                .openAdminProfileMenu()
                .clickLogOutBtn()
                .getHeader();
        String logOutString = home.getUserIdentity().getAttribute("aria-label");

        Assert.assertEquals(headerGroup,"Додати гурток");
        Assert.assertEquals(headerCenter,"Додати центр");
        Assert.assertEquals(hrefProfilePage, "page");
        Assert.assertEquals(logOutString, "user");
    }
}
