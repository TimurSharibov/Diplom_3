package test;

import page.LoginPage;
import utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    protected static final String BROWSER = "chrome";
    protected WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Установка неявного ожидания
        webDriver.get("https://stellarburgers.nomoreparties.site");
    }

    protected void login(String email, String password) {
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
