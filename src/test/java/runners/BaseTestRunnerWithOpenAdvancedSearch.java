package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTestRunnerWithOpenAdvancedSearch extends BaseTestRunner{

    @BeforeMethod
    public void setUp(){
        super.setUp();
        new HomePage(driver).clickAdvancedSearchButton();
    }
}
