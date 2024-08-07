import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;
import page.LoginPage;
import page.RegistrationPage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import static Utils.DataGenerator.getRandomEmail;
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
    public void RegistrationWithCorrectData() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegistrationButton();

        new WebDriverWait(webDriver, ofSeconds(10)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        // Проверка наличия кнопки "Оформить заказ"
        boolean orderButtonDisplayed = constructorPage.isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
//        deleteUser();
    }

    @Test
    public void RegistrationWithIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.enterName("Tim");
        registrationPage.enterEmail(email);
        registrationPage.enterPassword("p123");
        registrationPage.clickRegistrationButton();

        boolean answerIsDisplayed = registrationPage.errorTextIsDisplayed("Некорректный пароль");
        assertTrue(answerIsDisplayed);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {

        }
        webDriver.quit();
    }

//    private void deleteUser() {
//        try {
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://stellarburgers.nomoreparties.site/api/auth/user"))
//                    .header("Authorization", accessToken)
//                    .DELETE()
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("User deletion response status: " + response.statusCode());
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void getAccessToken() {
//        try {
//            HttpClient client = HttpClient.newHttpClient();
//            String json = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password);
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://stellarburgers.nomoreparties.site/api/auth/login"))
//                    .header("Content-Type", "application/json")
//                    .POST(BodyPublishers.ofString(json))
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            if (response.statusCode() == 200) {
//                // Парсинг JSON для получения токена доступа
//                JSONObject jsonResponse = new JSONObject(response.body());
//                accessToken = "Bearer " + jsonResponse.getJSONObject("access").getString("token");
//            } else {
//                System.out.println("Failed to get access token, response status: " + response.statusCode());
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
