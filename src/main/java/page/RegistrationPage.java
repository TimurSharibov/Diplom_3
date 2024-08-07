package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {
    private static  WebDriver webDriver;

    // Локаторы
    private By nameInputLocator = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailInputLocator = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInputLocator = By.xpath("//input[@type='password' and @name='Пароль']");
    private By registerButtonLocator = By.xpath("//button[text()='Зарегистрироваться']");

    private By errorTextLocator = By.xpath("//p[text()='Некорректный пароль']");
    private static By loginButtonLocator = By.xpath("//a[text()='Войти']");


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void enterName(String userName) {
        WebElement nameInput = webDriver.findElement(nameInputLocator);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(userName);
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

    public void clickRegistrationButton() {
        WebElement registrationButton = webDriver.findElement(registerButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();
    }
    public boolean errorTextIsDisplayed(String expectedText) {
        try {
            By errorTextDynamicLocator = By.xpath("//p[text()='" + expectedText + "']");
            WebElement element = new WebDriverWait(webDriver, ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(errorTextDynamicLocator));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(loginButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

}
