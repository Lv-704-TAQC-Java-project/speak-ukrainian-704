package pages;

import org.openqa.selenium.WebDriver;
import pages.components.HeaderMenuListComponent;

public class ServicePage extends BasePage{

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage openClubsPage() {
        return new HeaderMenuListComponent(driver).openClubsPage();
    }

    public ServicePage openChallengeMenu() {
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
