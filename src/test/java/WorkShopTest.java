import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WorkShopTest extends BaseMethods {

    @Test(priority = 1)
    public void linkIsDisplayed() {
        WorkShopPageElements elements = new WorkShopPageElements(driver);
        elements.getWorkShopLink().isDisplayed();
    }

    @Test(priority = 2)
    public void workShopCount() {
        WorkShopPageElements elements = new WorkShopPageElements(driver);
        elements.clickWorkShopLink();
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'ant-card-body']"));
        int amount = items.size();
        Assert.assertEquals(amount, 8, "Number of Workshops expected is 8 but was " + amount);
    }

}
