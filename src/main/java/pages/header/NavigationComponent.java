package pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import pages.clubs.ClubsPage;

import java.util.List;

public class NavigationComponent extends BasePage {

    private WebElement homePageLink;
    private WebElement clubsLinkBtn;
    private WebElement challengeBtn;
    private WebElement newsLinkBtn;
    private WebElement aboutLinkBtn;
    private WebElement serviceLinkBtn;
    private WebElement challengeMenu;
    private List<WebElement> challengesList;
    private WebElement clubsLinkWrapper;
    private WebElement challengesLinkWrapper;
    private WebElement newsLinkWrapper;
    private WebElement aboutLinkWrapper;
    private WebElement serviceLinkWrapper;

    public NavigationComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getHomePageLink() {
        if (homePageLink == null) {
            waitVisibilityOfElement(By.xpath("//header//div[contains(@class, 'logo')]/parent::a"));
            homePageLink = driver.findElement(By.xpath("//header//div[contains(@class, 'logo')]/parent::a"));
        }
        return homePageLink;
    }

    public WebElement getClubsLinkBtn() {
        if (clubsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
            clubsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'clubs')]"));
        }
        return clubsLinkBtn;
    }

    public WebElement getClubsLinkWrapper() {
        if (clubsLinkWrapper == null) {
            clubsLinkWrapper =  driver.findElement(By.xpath("//a[contains(@href, 'clubs')]/parent::span"));
        }
        return clubsLinkWrapper;
    }

    public WebElement getClubsLinkWrapperWithAttributeValue(String attribute, String value) {
        waitForAttributeValueWithJS(getClubsLinkWrapper(), attribute, value);
        return driver.findElement(By.xpath("//a[contains(@href, 'clubs')]/parent::span"));
    }

    public WebElement getChallengeBtn() {
        if (challengeBtn == null) {
            waitVisibilityOfElement(By.xpath("//div/span[@class='ant-menu-title-content']"));
            challengeBtn = driver.findElement(By.xpath("//div/span[@class='ant-menu-title-content']"));
        }
        return challengeBtn;
    }

    public List<WebElement> getChallengesList() {
        if (challengesList == null) {
            challengesList = driver.findElements(By.xpath("//ul//a[contains(@href, 'challenges')]"));
        }
        return challengesList;
    }

    public void clickOnFirstChallengeFromList() {
        getChallengesList().get(1).click();
    }

    public WebElement getChallengesLinkWrapper() {
        if (challengesLinkWrapper == null) {
            challengesLinkWrapper =  driver.findElement(By.xpath("//li[contains(@id, 'challenge')]/div[contains(@class, 'submenu')]"));
        }
        return challengesLinkWrapper;
    }

    public WebElement getChallengesLinkWrapperWithAttributeValue(String attribute, String value) {
        waitForAttributeValueWithJS(getChallengesLinkWrapper(), attribute, value);
        return driver.findElement(By.xpath("//li[contains(@id, 'challenge')]/div[contains(@class, 'submenu')]"));
    }

    public WebElement getNewsLinkBtn() {
        if (newsLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'news')]"));
            newsLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'news')]"));
        }
        return newsLinkBtn;
    }

    public WebElement getNewsLinkWrapper() {
        if (newsLinkWrapper == null) {
            newsLinkWrapper =  driver.findElement(By.xpath("//a[contains(@href, 'news')]/parent::span"));
        }
        return newsLinkWrapper;
    }

    public WebElement getNewsLinkWrapperWithAttributeValue(String attribute, String value) {
        waitForAttributeValueWithJS(getNewsLinkWrapper(), attribute, value);
        return driver.findElement(By.xpath("//a[contains(@href, 'news')]/parent::span"));
    }

    public WebElement getAboutLinkBtn() {
        if (aboutLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'about')]"));
            aboutLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'about')]"));
        }
        return aboutLinkBtn;
    }

    public WebElement getAboutLinkWrapper() {
        if (aboutLinkWrapper == null) {
            aboutLinkWrapper =  driver.findElement(By.xpath("//a[contains(@href, 'about')]/parent::span"));
        }
        return aboutLinkWrapper;
    }

    public WebElement getAboutLinkWrapperWithAttributeValue(String attribute, String value) {
        waitForAttributeValueWithJS(getAboutLinkWrapper(), attribute, value);
        return driver.findElement(By.xpath("//a[contains(@href, 'about')]/parent::span"));
    }

    public WebElement getServiceLinkBtn() {
        if (serviceLinkBtn == null) {
            waitVisibilityOfElement(By.xpath("//header//a[contains(@href, 'service')]"));
            serviceLinkBtn = driver.findElement(By.xpath("//header//a[contains(@href, 'service')]"));
        }
        return serviceLinkBtn;
    }

    public WebElement getServiceLinkWrapper() {
        if (serviceLinkWrapper == null) {
            serviceLinkWrapper =  driver.findElement(By.xpath("//a[contains(@href, 'service')]/parent::span"));
        }
        return serviceLinkWrapper;
    }

    public WebElement getServiceLinkWrapperWithAttributeValue(String attribute, String value) {
        waitForAttributeValueWithJS(getServiceLinkWrapper(), attribute, value);
        return driver.findElement(By.xpath("//a[contains(@href, 'service')]/parent::span"));
    }

    public WebElement getChallengeMenu() {
        if (challengeMenu == null) {
            waitVisibilityOfElement(By.xpath("//div[@class='ant-menu-submenu ant-menu-submenu-popup ant-menu ant-menu-light ant-menu-submenu-placement-bottomLeft ']"));
            challengeMenu = driver.findElement(By.xpath("//div[@class='ant-menu-submenu ant-menu-submenu-popup ant-menu ant-menu-light ant-menu-submenu-placement-bottomLeft ']"));
        }
        return challengeMenu;
    }

    public HomePage openHomePage() {
        getHomePageLink().click();
        return new HomePage(driver);
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
