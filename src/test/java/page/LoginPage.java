package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @Step("Ввод email: {userEmail}")
    public void enterEmail(String userEmail) {
        WebElement emailInput = webDriver.findElement(emailInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(userEmail);
    }

    @Step("Ввод пароля")
    public void enterPassword(String userPassword) {
        WebElement passwordInput = webDriver.findElement(passwordInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(userPassword);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(loginButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    @Step("Проверка отображения кнопки 'Войти'")
    public boolean isLoginButtonDisplayed() {
        try {
            return webDriver.findElement(loginButtonLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
