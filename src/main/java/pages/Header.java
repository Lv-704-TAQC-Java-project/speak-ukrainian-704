package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {

    private WebElement clubsLinkBtn;
    private WebElement challengeBtn;
    private WebElement newsLinkBtn;
    private WebElement aboutLinkBtn;
    private WebElement serviceLinkBtn;

    public Header(WebDriver driver) {
        super(driver);
    }

    public WebElement getClubsLinkBtn() {
        if (clubsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
            clubsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
        }
        return clubsLinkBtn;
    }

    public WebElement getChallengeBtn() {
        if (challengeBtn == null) {
            waitVisibilityOfElement(By.xpath("//div/span[@class='ant-menu-title-content']"));
            challengeBtn = driver.findElement(By.xpath("//div/span[@class='ant-menu-title-content']"));
        }
        return challengeBtn;
    }

    public WebElement getNewsLinkBtn() {
        if (newsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'news')]"));
            newsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'news')]"));
        }
        return newsLinkBtn;
    }

    public WebElement getAboutLinkBtn() {
        if (aboutLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'about')]"));
            aboutLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'about')]"));
        }
        return aboutLinkBtn;
    }

    public WebElement getServiceLinkBtn() {
        if (serviceLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'service')]"));
            serviceLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'service')]"));
        }
        return serviceLinkBtn;
    }

    public ClubsPage openClubsPage() {
        getClubsLinkBtn().click();
        return new ClubsPage(driver);
    }

    public void openChallengeMenu() {
        getChallengeBtn().click();
    }

    public NewsPage openNewsPage() {
        getNewsLinkBtn().click();
        return new NewsPage(driver);
    }

    public AboutPage openAboutPage() {
        getAboutLinkBtn().click();
        return new AboutPage(driver);
    }

    public ServicePage openServicePage() {
        getServiceLinkBtn().click();
        return new ServicePage(driver);
    }

}
