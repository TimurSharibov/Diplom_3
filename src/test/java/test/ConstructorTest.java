package test;

//import utils.WebDriverFactory;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.ConstructorPage;
import utils.WebDriverFactory;

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
    @Step("Переход во вкладку Начинки")
    public void goToFilling() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();

        boolean fillingTextDisplayed = constructorPage.isFillingTextDisplayed();
        assertTrue(fillingTextDisplayed);
    }

    @Test
    @Step("Переход во вкладку Соусы")
    public void goToSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();

        boolean saucesTextDisplayed = constructorPage.isSaucesTextDisplayed();
        assertTrue(saucesTextDisplayed);
    }

    @Test
    @Step("Переход во вкладку Булки")
    public void goToBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);
    }

    @Test
    @Step("Переход по всем вкладкам")
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
