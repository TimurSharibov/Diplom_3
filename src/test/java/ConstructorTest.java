import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ConstructorPage;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private static final String BROWSER = "chrome";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @Step("������� �� ������� �������")
    public void goToFilling() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();

        boolean fillingTextDisplayed = constructorPage.isFillingTextDisplayed();
        assertTrue(fillingTextDisplayed);
    }

    @Test
    @Step("������� �� ������� �����")
    public void goToSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();

        boolean saucesTextDisplayed = constructorPage.isSaucesTextDisplayed();
        assertTrue(saucesTextDisplayed);
    }

    @Test
    @Step("������� �� ������� �����")
    public void goToBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);
    }

    @Test
    @Step("������� �� ���� ��������")
    public void goToFillingSaucesBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
