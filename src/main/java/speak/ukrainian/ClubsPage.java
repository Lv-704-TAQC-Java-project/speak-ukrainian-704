package speak.ukrainian;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubsPage extends BasePage {
    private WebElement advancedSearch;
    private WebElement advancedSearchTitle;

    public ClubsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getAdvancedSearch(){
        if (advancedSearch == null){
            advancedSearch = driver.findElement(By.xpath("//span[contains(@class, \"anticon-control\")]"));
        }
        return advancedSearch;
    }

    public WebElement getAdvancedSearchTitle(){
        if (advancedSearchTitle == null){
            advancedSearchTitle = driver.findElement(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
        }
        return advancedSearchTitle;
    }

    public void clickOnAdvancedSearch(){
        getAdvancedSearch().click();
    }
//    List<WebElement> towns = driver.findElements(By.xpath("//li[contains(@class, 'ant-dropdown')]"));
//    public ClubsPage() {
//        PageFactory.initElements(driver, this);
//    }
}
