package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {
    private final WebDriver webDriver;


    // поле для ввода имени
    private By nameInputLocator = By.xpath("//label[text()='Имя']");
    // поле для ввода Email
    private By emailInputLocator = By.xpath("//label[text()='Email']");

    // поле для ввода пароля
    private By passwordInputLocator = By.xpath("//label[text()='Пароль']");

    // кнопка Зарегистрироваться
    private By registerButtonLocator = By.xpath("//button[text()='Зарегистрироваться']");

    //кнопка Войти
    private By loginButtonLocator = By.xpath("//button[text()='Войти']");

    //кнопка оформить заказ
    private By orderButtonLocator = By.xpath("//button[text()='Оформить заказ']");

    //текст с ошибкой "Некорректный пароль"
    private By errorTextLocator = By.xpath("//p[text()='Некорректный пароль']");


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterName(String userName) {
        WebElement nameInput = webDriver.findElement(nameInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userName));
        nameInput.sendKeys(userName);
    }

    public void enterEmail(String userEmail) {
        WebElement emailInput = webDriver.findElement(nameInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userEmail));
        emailInput.sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        WebElement passwordInput = webDriver.findElement(nameInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userPassword));
        passwordInput.sendKeys(userPassword);
    }

    public void clickRegistrationButton() {
        WebElement registrationButton = webDriver.findElement(registerButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();
    }

    public void clickLoginButton() {
        WebElement LoginButton = webDriver.findElement(loginButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(LoginButton));
        LoginButton.click();
    }

    public boolean isOrderButtonDisplayed() {
        try {
            return webDriver.findElement(orderButtonLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
