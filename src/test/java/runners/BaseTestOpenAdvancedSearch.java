package runners;

import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTestOpenAdvancedSearch extends BaseTestOneWindowRunner{
    @BeforeClass
    public void ClassSetUp(){
        super.ClassSetUp();
        new HomePage(driver).clickAdvancedSearchButton();
    }
}
