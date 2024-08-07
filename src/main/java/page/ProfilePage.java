package page;
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
    private static By constructorButtonLocator = By.xpath("//p[text()='Конструктор']");
    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static boolean isProfileTextDisplayed() {
        try {
            return webDriver.findElement(profileTextLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickConstructorButton() {
        WebElement constructorButton = webDriver.findElement(constructorButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorButton.click();
    }
}
