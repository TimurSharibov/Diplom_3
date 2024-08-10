package test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.RegistrationPage;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
//    @DisplayName
    public void LoginFromHomePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickLoginToAccountButton();
        login("ordersuser@example.com", "password123");

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromProfile() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickProfileButton();
        login("ordersuser@example.com", "password123");

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.clickLoginButton();
        login("ordersuser@example.com", "password123");

        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LoginFromPasswordRecovery() {
        webDriver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.clickLoginButton();
        login("ordersuser@example.com", "password123");

        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }
}
