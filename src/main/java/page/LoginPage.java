package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class LoginPage {

    private final WebDriver webDriver;

    private By loginButtonLocator = By.xpath("//button[text()='Войти']");
    private By emailInputLocator = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInputLocator = By.xpath("//input[@type='password' and @name='Пароль']");



    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void enterEmail(String userEmail) {
        WebElement emailInput = webDriver.findElement(emailInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        WebElement passwordInput = webDriver.findElement(passwordInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(userPassword);
    }
    public void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(loginButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }


}
