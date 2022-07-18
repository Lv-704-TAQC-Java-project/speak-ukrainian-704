import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WorkShop extends BasePage {

    private WebElement workShopLink;
    private List<WebElement> clubs;

    public WorkShop(WebDriver driver) {
        super(driver);
    }

    public WebElement getWorkShopLink() {
        if (workShopLink == null) {
            workShopLink = driver.findElement(By.xpath("//div/ul/li/span/a[text() = 'Гуртки']"));
        }
        return workShopLink;
    }

    public List<WebElement> getClubs() {
        if (clubs == null) {
            clubs = driver.findElements(By.xpath("//div[@class = 'ant-card-body']"));
        }
        return clubs;
    }

    public WorkShop clickWorkShopLink() {
        getWorkShopLink().click();
        return this;
    }


}
