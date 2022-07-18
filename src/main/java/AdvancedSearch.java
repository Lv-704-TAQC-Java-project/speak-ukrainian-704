import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSearch extends BasePage {

    private WebElement advancedSearch;
    private WebElement searchBlock;

    public AdvancedSearch(WebDriver driver) {
        super(driver);
    }

    public WebElement getAdvancedSearch() {
        if (advancedSearch == null) {
            advancedSearch = driver.findElement(By.xpath("//div[@class = 'search-icon-group']/span[@class = 'anticon anticon-control advanced-icon']"));
        }
        return advancedSearch;
    }

    public WebElement getSearchBlock() {
        if (searchBlock == null) {
            searchBlock = driver.findElement(By.xpath("//section/aside/div[@class = 'ant-layout-sider-children']"));
        }
        return searchBlock;
    }

    public AdvancedSearch clickAdvancedSearch() {
        getAdvancedSearch().click();
        return this;
    }



}
