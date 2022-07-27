package runners;

import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.clubs.ClubsPage;

public class BaseTestOpenAdvancedSearch extends BaseTestOneWindowRunner{
    @BeforeClass
    public void ClassSetUp(){
        super.ClassSetUp();
        new HomePage(driver).clickAdvancedSearchButton();
    }
}
