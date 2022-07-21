package pages;

import org.openqa.selenium.WebDriver;
import pages.components.HeaderMenuListComponent;

public class NewsPage extends BasePage{
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage openClubsPage() {
        return new HeaderMenuListComponent(driver).openClubsPage();
    }

    public NewsPage openChallengeMenu() {
        new HeaderMenuListComponent(driver).openChallengeMenu();
        return this;
    }

    public NewsPage openNewsPage() {
        return new HeaderMenuListComponent(driver).openNewsPage();
    }

    public ServicePage openServicePage() {
        return new HeaderMenuListComponent(driver).openServicePage();
    }

    public AboutPage openAboutPage() {
        return new HeaderMenuListComponent(driver).openAboutPage();
    }
}
