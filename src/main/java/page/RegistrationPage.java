package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {
    private final WebDriver webDriver;

    // Локаторы
    private By nameInputLocator = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailInputLocator = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInputLocator = By.xpath("//input[@type='password' and @name='Пароль']");
    private By registerButtonLocator = By.xpath("//button[text()='Зарегистрироваться']");
  //  private By loginButtonLocator = By.xpath("//button[text()='Войти']");
//    private By orderButtonLocator = By.xpath("//button[text()='Оформить заказ']");
    private By errorTextLocator = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


//    public void enterName(String userName) {
//        WebElement nameInput = webDriver.findElement(nameInputLocator);
//        new WebDriverWait(webDriver, ofSeconds(5))
//                .until(ExpectedConditions.visibilityOf(nameInput));
//        nameInput.sendKeys(userName);
//    }

//    public void enterName(String userName) {
//        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
//        WebElement nameInput;
//        try {
//            nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInputLocator));
//            nameInput.sendKeys(userName);
//        } catch (TimeoutException e) {
//            throw new RuntimeException("Элемент 'Имя' не найден или не видим на странице.", e);
//        }
//    }

    public void enterName(String userName) {
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        try {
            WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(nameInputLocator));
            nameInput.sendKeys(userName);
        } catch (TimeoutException e) {
            throw new RuntimeException("Элемент 'Имя' не найден на странице.", e);
        }
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
    public boolean errorTextIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(expectedAnswer, errorTextLocator)));
        return element.isDisplayed();
    }


//    public void clickLoginButton() {
//        WebElement loginButton = webDriver.findElement(loginButtonLocator);
//        new WebDriverWait(webDriver, ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(loginButton));
//        loginButton.click();
//    }

//    public boolean isOrderButtonDisplayed() {
//        try {
//            return webDriver.findElement(orderButtonLocator).isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
}
