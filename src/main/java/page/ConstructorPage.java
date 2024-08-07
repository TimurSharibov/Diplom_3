package page;
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

    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isOrderButtonDisplayed() {
        try {
            return webDriver.findElement(orderButtonLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static void clickLoginToAccountButton() {
        WebElement loginToAccountButton = webDriver.findElement(loginToAccountButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginToAccountButton));
        loginToAccountButton.click();
    }

    public static void clickProfileButton() {
        WebElement profileButton = webDriver.findElement(profileButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }



}
