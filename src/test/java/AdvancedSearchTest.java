import org.testng.annotations.Test;

public class AdvancedSearchTest extends BaseMethods{

    @Test
    public void advancedSearchTest() {
        AdvancedSearch elements = new AdvancedSearch(driver);
        getHomepage();
        elements.clickAdvancedSearch().getSearchBlock().isDisplayed();
    }
}
