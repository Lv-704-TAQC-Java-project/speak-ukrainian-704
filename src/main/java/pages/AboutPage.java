package pages;

import org.openqa.selenium.WebDriver;
import pages.components.HeaderMenuListComponent;

public class AboutPage extends BasePage{
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage openClubsPage() {
        return new HeaderMenuListComponent(driver).openClubsPage();
    }

    public AboutPage openChallengeMenu() {
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
