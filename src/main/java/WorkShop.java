import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkShop extends BasePage{

    private WebElement workShopLink;

    public WorkShop(WebDriver driver) {
        super(driver);
    }

    public WebElement getWorkShopLink() {
        if (workShopLink == null) {
            workShopLink = driver.findElement(By.xpath("//div/ul/li/span/a[text() = 'Гуртки']"));
        }
        return workShopLink;
    }

    public WorkShop clickWorkShopLink() {
        getWorkShopLink().click();
        return this;
    }


}
