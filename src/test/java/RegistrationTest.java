import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
//import java.WebDriverFactory;
import page.RegistrationPage;


import static org.junit.Assert.assertTrue;

import static java.time.Duration.ofSeconds;



public class RegistrationTest {

    private static final String BROUSER = "chrome";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROUSER);
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }


    @Test
    public void Registration() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail("tim@mail.ru");
        registrationPage.enterPassword("password123");
        registrationPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        // Ожидание перехода на страницу после регистрации, можно заменить если требуется
        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlContains("someExpectedURL"));

        // Проверка наличия кнопки "Оформить заказ"
        boolean isOrderButtonDisplayed = registrationPage.isOrderButtonDisplayed();
        assertTrue(isOrderButtonDisplayed);
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }




}
