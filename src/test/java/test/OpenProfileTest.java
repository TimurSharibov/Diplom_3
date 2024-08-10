package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.LoginPage;
import page.ProfilePage;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class OpenProfileTest extends BaseTest {

    @Before
    public void setup() {
        super.setup();
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickLoginToAccountButton();
        login("ordersuser@example.com", "password123");
    }

    @Test
    public void OpenProfilePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickProfileButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));

        ProfilePage profilePage = new ProfilePage(webDriver);
        // Проверка наличия кнопки "Оформить заказ"
        boolean profileTextDisplayed = profilePage.isProfileTextDisplayed();
        assertTrue(profileTextDisplayed);
    }

    @Test
    public void OpenConstructorFromProfilePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickConstructorButton();

        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    @Test
    public void LogoutFromProfilePage() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickProfileButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickLogoutButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        LoginPage loginPage = new LoginPage(webDriver);
        boolean loginButtonDisplayed = loginPage.isLoginButtonDisplayed();
        assertTrue(loginButtonDisplayed);
    }
}
