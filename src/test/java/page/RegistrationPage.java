package page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {

    private static WebDriver webDriver;
    private By nameInputLocator = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailInputLocator = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInputLocator = By.xpath("//input[@type='password' and @name='Пароль']");
    private By registerButtonLocator = By.xpath("//button[text()='Зарегистрироваться']");
    private By incorrectPasswordErrorLocator = By.xpath("//p[text()='Некорректный пароль']");
    private static By loginButtonLocator = By.xpath("//a[text()='Войти']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Step("Ввод имени: {userName}")
    public void enterName(String userName) {
        WebElement nameInput = new WebDriverWait(webDriver, ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(nameInputLocator));
        nameInput.sendKeys(userName);
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

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        WebElement registerButton = webDriver.findElement(registerButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }

    @Step("Проверка отображения ошибки 'Некорректный пароль'")
    public boolean isIncorrectPasswordErrorDisplayed(String некорректный_пароль) {
        try {
            new WebDriverWait(webDriver, ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordErrorLocator));
            return webDriver.findElement(incorrectPasswordErrorLocator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Клик по кнопке 'Войти'")
    public static void clickLoginButton() {
        WebElement loginButton = webDriver.findElement(loginButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
