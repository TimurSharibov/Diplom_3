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

public class RegistrationTest {
    private static final String BROUSER = "chrome";
    private WebDriver webDriver;

    private String email = getRandomEmail();


    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROUSER);
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }
    @Test
    public void RegistrationWithCorrectData() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);


        registrationPage.enterName("Tim");
        registrationPage.enterEmail(email);
        registrationPage.enterPassword("password123");
        registrationPage.clickRegistrationButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail(email);
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();


        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        // Проверка наличия кнопки "Оформить заказ"
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void RegistrationWithIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail("tim@mail.ru");
        registrationPage.enterPassword("p123");
        registrationPage.clickRegistrationButton();

        boolean answerIsDisplayed = registrationPage.errorTextIsDisplayed("Некорректный пароль");
        assertTrue(answerIsDisplayed);
    }



    @After
    public void tearDown() {
        webDriver.quit();
    }
}