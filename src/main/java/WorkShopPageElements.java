import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WorkShopPageElements {

    WebDriver driver;

    public WorkShopPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div/ul/li/span/a[text() = 'Гуртки']")
    private WebElement workShopLink;

    public WebElement getWorkShopLink() {
        return workShopLink;
    }

    public WorkShopPageElements clickWorkShopLink() {
        workShopLink.click();
        return this;
    }


}
