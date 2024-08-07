import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.RegistrationPage;


import static Utils.DataGenerator.getRandomEmail;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private static final String BROUSER = "chrome";
    private WebDriver webDriver;

    private String email = getRandomEmail();


    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROUSER);
        webDriver.get("https://stellarburgers.nomoreparties.site");
    }
    @Test
    public void LoginFromHomePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);

        ConstructorPage.clickLoginToAccountButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail("ordersuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка наличия кнопки "Оформить заказ"
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromProfile() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);

        ConstructorPage.clickProfileButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail("ordersuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка наличия кнопки "Оформить заказ"
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        RegistrationPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail("ordersuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка наличия кнопки "Оформить заказ"
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromPasswordRecovery() {
        webDriver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);

        forgotPasswordPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail("ordersuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка наличия кнопки "Оформить заказ"
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }



    @After
    public void tearDown() {
        webDriver.quit();
    }
}
