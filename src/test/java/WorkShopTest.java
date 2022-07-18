import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WorkShopTest extends BaseMethods {

    @Test
    public void workShopCount() {
        WorkShop elements = new WorkShop(driver);
        getHomepage();
        elements.clickWorkShopLink();
        List<WebElement> items = elements.getClubs();
        int amount = items.size();
        Assert.assertEquals(amount, 8, "Number of Workshops expected is 8 but was " + amount);
    }

}
