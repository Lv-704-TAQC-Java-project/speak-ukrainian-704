import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import speak.ukrainian.ClubsPage;
import speak.ukrainian.MainPage;

public class AdvancedSearchTest extends BaseTest{

    public MainPage getMainPage(){
        return new MainPage(BasePage.driver);
    }

    public ClubsPage getClubsPage(){
        return new ClubsPage(BasePage.driver);
    }

    @Test
    public void isDisplayed() {
        getMainPage().goToAdvancedSearch();
        boolean isDisp = getClubsPage().getAdvancedSearchTitle().isDisplayed();
        Assert.assertTrue(isDisp);
        getClubsPage().clickOnAdvancedSearch();
        isDisp = getClubsPage().getAdvancedSearchTitle().isDisplayed();
        Assert.assertFalse(isDisp);
    }

//    @Test
//    public void isDisplayedNegative() {
//
//    }
}
