import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;


import static Utils.DataGenerator.getRandomEmail;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class OpenProfileTest {
    private static final String BROUSER = "chrome";
    private WebDriver webDriver;


    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROUSER);
        webDriver.get("https://stellarburgers.nomoreparties.site");
        ConstructorPage constructorPage = new ConstructorPage(webDriver);

        ConstructorPage.clickLoginToAccountButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail("ordersuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    public void OpenProfilePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);

        ConstructorPage.clickProfileButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));

        ProfilePage profilePage = new ProfilePage(webDriver);
        // Проверка наличия кнопки "Оформить заказ"
        boolean profileTextDisplayed = ProfilePage.isProfileTextDisplayed();
        assertTrue(profileTextDisplayed);
    }

    @Test
    public void OpenConstructorFromProfilePage() {

        ConstructorPage constructorPage = new ConstructorPage(webDriver);

        constructorPage.clickProfileButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickConstructorButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
