package test;

import io.qameta.allure.junit4.DisplayName;
import utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.LoginPage;
import page.RegistrationPage;

import static utils.DataGenerator.getRandomEmail;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private static final String BROWSER = "chrome";
    private WebDriver webDriver;

    private String email = getRandomEmail();
    private String password = "password123";
    private String accessToken;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Регистрация с корректными данными")
    public void RegistrationWithCorrectData() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegistrationButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        // Проверка наличия кнопки "Оформить заказ"
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);

    }

    @Test
    @DisplayName("Регистрация с не корректным паролем")
    public void RegistrationWithIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail(email);
        registrationPage.enterPassword("p123");
        registrationPage.clickRegistrationButton();

        boolean answerIsDisplayed = registrationPage.isIncorrectPasswordErrorDisplayed("Некорректный пароль");
        assertTrue(answerIsDisplayed);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {

        }
        webDriver.quit();
    }

}