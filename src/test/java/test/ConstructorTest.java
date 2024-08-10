package test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.ConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {



    @Test
    @DisplayName("Переход во вкладку Начинки")
    public void goToFilling() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingButton();

        boolean fillingTextDisplayed = constructorPage.isFillingTextDisplayed();
        assertTrue(fillingTextDisplayed);
    }

    @Test
    @DisplayName("Переход во вкладку Соусы")
    public void goToSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();

        boolean saucesTextDisplayed = constructorPage.isSaucesTextDisplayed();
        assertTrue(saucesTextDisplayed);
    }

    @Test
    @DisplayName("Переход во вкладку Булки")
    public void goToBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();
//        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);
    }

    @Test
    @DisplayName("Переход по всем вкладкам")
    public void goToFillingSaucesBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesButton();
        constructorPage.clickFillingButton();
        constructorPage.clickBunsButton();

        boolean bunsTextDisplayed = constructorPage.isBunsTextDisplayed();
        assertTrue(bunsTextDisplayed);
    }

}
