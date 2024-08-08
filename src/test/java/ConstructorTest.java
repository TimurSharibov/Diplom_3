import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.LoginPage;
import page.RegistrationPage;


import static Utils.DataGenerator.getRandomEmail;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private static final String BROUSER = "chrome";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROUSER);
        webDriver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @Step ("Переход во вкладку Начинки")
    public void GoToFilling() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();

        boolean fillingTextDisplayed = constructorPage.isFillingTextDisplayed();
        assertTrue(fillingTextDisplayed);

    }

    @Test
    @Step ("Переход во вкладку Соусы")
    public void GoToSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();

        boolean saucesTextDisplayed = constructorPage.isSaucesTextDisplayed();
        assertTrue(saucesTextDisplayed);

    }

    @Test
    @Step ("Переход во вкладку Булки")
    public void GoToBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);

    }
    @Test
    @Step ("Переход по всем вкладкам")
    public void GoToFillingSaucesBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
