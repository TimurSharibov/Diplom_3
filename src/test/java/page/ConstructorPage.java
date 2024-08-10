package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ConstructorPage {

    private static WebDriver webDriver;

    private By orderButtonLocator = By.xpath("//button[text()='Оформить заказ']");
    private static By loginToAccountButtonLocator = By.xpath("//button[text()='Войти в аккаунт']");
    private static By profileButtonLocator = By.xpath("//p[text()='Личный Кабинет']");
    private By fillingButtonLocator = By.xpath("//span[text()='Начинки']");
    private By saucesButtonLocator = By.xpath("//span[text()='Соусы']");
    private By bunsButtonLocator = By.xpath("//span[text()='Булки']");
    private By fillingTextLocator = By.xpath("//h2[text()='Начинки']");
    private By saucesTextLocator = By.xpath("//h2[text()='Соусы']");
    private By bunsTextLocator = By.xpath("//h2[text()='Булки']");

    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isOrderButtonDisplayed() {
        try {
            return webDriver.findElement(orderButtonLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public static void clickLoginToAccountButton() {
        WebElement loginToAccountButton = webDriver.findElement(loginToAccountButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginToAccountButton));
        loginToAccountButton.click();
    }

    @Step("Клик по кнопке 'Личный Кабинет'")
    public static void clickProfileButton() {
        WebElement profileButton = webDriver.findElement(profileButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }

    @Step("Клик по кнопке 'Начинки'")
    public void clickFillingButton() {
        WebElement fillingButton = webDriver.findElement(fillingButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        fillingButton.click();
    }

    @Step("Клик по кнопке 'Соусы'")
    public void clickSaucesButton() {
        WebElement saucesButton = webDriver.findElement(saucesButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(saucesButton));
        saucesButton.click();
    }

    @Step("Клик по кнопке 'Булки'")
    public void clickBunsButton() {
        WebElement bunsButton = webDriver.findElement(bunsButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(bunsButton));
        bunsButton.click();
    }

    @Step("Проверка отображения текста 'Начинки'")
    public boolean isFillingTextDisplayed() {
        try {
            return webDriver.findElement(fillingTextLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Проверка отображения текста 'Соусы'")
    public boolean isSaucesTextDisplayed() {
        try {
            return webDriver.findElement(saucesTextLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Проверка отображения текста 'Булки'")
    public boolean isBunsTextDisplayed() {
        try {
            return webDriver.findElement(bunsTextLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
