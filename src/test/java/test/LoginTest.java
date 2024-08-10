package test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.ConstructorPage;
import page.ForgotPasswordPage;
import page.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
//    @DisplayName
    public void LoginFromHomePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickLoginToAccountButton();
        login("ordersuser@example.com", "password123");

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void LoginFromProfile() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickProfileButton();
        login("ordersuser@example.com", "password123");

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
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
    @DisplayName("Вход через кнопку в форме восстановления пароля")
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
