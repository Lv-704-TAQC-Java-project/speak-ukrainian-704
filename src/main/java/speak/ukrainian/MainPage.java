package speak.ukrainian;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    private WebElement iconToLogin;
    private WebElement loginButton;
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement selectTown;
    private WebElement successMsg;
    private WebElement failMsg;
    private List<WebElement> townsDropdown;
    private List<WebElement> cards;
    private WebElement goToNextCards;
    private WebElement advancedSearch;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getIconToLogin() {
        if (iconToLogin == null){
            iconToLogin = driver.findElement(By.xpath("//span[contains(@class, 'ant-avatar')]"));
        }
        return iconToLogin;
    }

    public WebElement getLoginButton() {
        if (loginButton == null){
            loginButton = driver.findElement(By.xpath("//div[contains(text(), 'Увійти')]"));
        }
        return loginButton;
    }

    public WebElement getEmailInput() {
        if (emailInput == null){
            emailInput = driver.findElement(By.id("basic_email"));
        }
        return emailInput;
    }

    public WebElement getPasswordInput() {
        if (passwordInput == null){
            passwordInput = driver.findElement(By.id("basic_password"));
        }
        return passwordInput;
    }

    public WebElement getSelectTown() {
        if (selectTown == null){
            selectTown = driver.findElement(By.xpath("//div[contains(@class, \"ant-dropdown\")]"));
        }
        return selectTown;
    }

    public WebElement getSuccessMsg(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if (successMsg == null){
            successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]")));
        }
        return successMsg;
    }

    public WebElement getFailMsg(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if (failMsg == null){
            failMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]")));
        }
        return failMsg;
    }

    public List<WebElement> getTownsDropdown(){
        if (townsDropdown == null){
            townsDropdown = driver.findElements(By.xpath("//li[contains(@class, 'ant-dropdown')]"));
        }
        return townsDropdown;
    }

    public List<WebElement> getCards(){
        if (cards == null){
            cards = driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]"));
        }
        return cards;
    }

    public WebElement getGoToNextCards(){
        if (goToNextCards == null){
            goToNextCards = driver.findElement(By.xpath("//li[contains(@class, 'ant-pagination-next')]"));
        }
        return goToNextCards;
    }

    public WebElement getAdvancedSearch(){
        if (advancedSearch == null){
            advancedSearch = driver.findElement(By.xpath("//span[contains(@class, \"anticon-control\")]"));
        }
        return advancedSearch;
    }

    public void login(String email, String password) {
        getIconToLogin().click();
        getLoginButton().click();
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getPasswordInput().submit();
    }

    public String successfulLogin(String email, String password) {
        login(email, password);
        return getSuccessMsg().getText();
    }

    public String unsuccessfulLogin(String email, String password) {
        login(email, password);
        return getFailMsg().getText();
    }

    public List<Integer> countClubs(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<Integer> listOfNumbersOfClubs = new ArrayList<>();
        getSelectTown().click();
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
            wait.until(ExpectedConditions.elementToBeClickable(getSelectTown())).click();
        }
        return listOfNumbersOfClubs;
    }

    public void goToAdvancedSearch(){
        getAdvancedSearch().click();
        new ClubsPage(BasePage.driver);
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
