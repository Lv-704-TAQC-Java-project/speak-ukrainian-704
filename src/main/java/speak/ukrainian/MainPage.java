package speak.ukrainian;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'ant-avatar')]")
    private WebElement iconToLogin;

    @FindBy(xpath = "//div[contains(text(), 'Увійти')]")
    private WebElement loginButton;

    @FindBy(id = "basic_email")
    private WebElement emailInput;

    @FindBy(id = "basic_password")
    private WebElement passwordInput;

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
        WebElement successMsg = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'успішно')]"));
        return successMsg.getText();
    }

    public String unsuccessfulLogin(String email, String password) {
        login(email, password);
        WebElement failMsg = driver.findElement(By.xpath("//div[@class='ant-message']//span[contains(text(), 'невірний')]"));
        return failMsg.getText();
    }


}
