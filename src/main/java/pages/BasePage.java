package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasePage {
    protected final String BASE_URL = "https://speak-ukrainian.org.ua/dev/";
    protected final Duration TIMEOUT = Duration.ofSeconds(10);

    WebDriver driver;
    protected final Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void waitForPageToLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, TIMEOUT);
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState;").equals("complete")); //"interactive"
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void waitForPageToReload() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, TIMEOUT);
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState;").equals("loading"));
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState;").equals("complete"));
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void waitVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitVisibilityOfElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitInvisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
