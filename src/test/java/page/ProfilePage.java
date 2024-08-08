package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ProfilePage {

    private static WebDriver webDriver;
    private static By profileTextLocator = By.xpath("//a[text()='Профиль']");
    private By constructorButtonLocator = By.xpath("//p[text()='Конструктор']");
    private By logoutButtonLocator = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка отображения текста 'Профиль'")
    public static boolean isProfileTextDisplayed() {
        try {
            return webDriver.findElement(profileTextLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        WebElement constructorButton = webDriver.findElement(constructorButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorButton.click();
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickLogoutButton() {
        WebElement logoutButton = webDriver.findElement(logoutButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}
