package page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static java.time.Duration.ofSeconds;

public class ConstructorPage {

    private final WebDriver webDriver;

    private By orderButtonLocator = By.xpath("//button[text()='Оформить заказ']");

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

}
