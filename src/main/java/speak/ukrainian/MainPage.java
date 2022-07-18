package speak.ukrainian;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'ant-avatar')]")
    private WebElement iconToLogin;

    @FindBy(xpath = "//div[contains(text(), 'Увійти')]")
    private WebElement loginButton;

    @FindBy(id = "basic_email")
    private WebElement emailInput;

    @FindBy(id = "basic_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[contains(@class, \"ant-dropdown\")]")
    WebElement selectTown;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        iconToLogin.click();
        loginButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordInput.submit();
    }

    public String successfulLogin(String email, String password) {
        login(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]")));
        return successMsg.getText();
    }

    public String unsuccessfulLogin(String email, String password) {
        login(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement failMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]")));
        return failMsg.getText();
    }

    public List<Integer> goToTowns(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<Integer> listOfNumbersOfClubs = new ArrayList<>();
        selectTown.click();
        List<WebElement> towns = driver.findElements(By.xpath("//li[contains(@class, 'ant-dropdown')]"));
        for (WebElement el : towns){
            int numberOfClubs = 0;
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
            if (driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]")).size() > 0){
                waitForPageToLoad();
                numberOfClubs += (driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]")).size());
                if (driver.findElements(By.xpath("//li[contains(@class, 'ant-pagination-next')]")).size() > 0){
                    waitForPageToLoad();
                    while (driver.findElement(By.xpath("//li[contains(@class, 'ant-pagination-next')]"))
                            .getAttribute("aria-disabled").equals("false")) {
                        driver.findElement(By.xpath("//li[contains(@class, 'ant-pagination-next')]")).click();
                        numberOfClubs += (driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]")).size());
                    }
                }
            }
            listOfNumbersOfClubs.add(numberOfClubs);
            wait.until(ExpectedConditions.elementToBeClickable(selectTown)).click();
        }
        return listOfNumbersOfClubs;
    }

    public void waitForPageToLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState;").equals("complete")); //"interactive"
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

}
