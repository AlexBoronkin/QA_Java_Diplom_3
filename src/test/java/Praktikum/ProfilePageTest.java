package Praktikum;

import Praktikum.dataForTests.BaseDate;
import Praktikum.pageObjects.LoginPage;
import Praktikum.pageObjects.MainPage;
import Praktikum.pageObjects.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import Praktikum.dataForTests.BaseDate.*;
import static Praktikum.dataForTests.BaseDate.EMAIL_FOR_TEST;
import static Praktikum.dataForTests.BaseDate.PASSWORD_FOR_TEST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePageTest {
    private WebDriver driver;
    MainPage objMainPage;
    LoginPage objLoginPage;
    ProfilePage objProfilePage;
    WebDriverSelection chooseDriver = new WebDriverSelection();


    @Before
    public void setUp() {
        driver = chooseDriver.chooseYourBrowser("chrome");
        driver.navigate().to(BaseDate.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objMainPage = new MainPage(driver);
        objMainPage.clickAccountButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        objMainPage.clickAccountButton();
        objProfilePage = new ProfilePage(driver);

    }

    @Test
    @DisplayName("Проверяем переход на главную страницу из ЛК кликом на Конструктор")
    public void clickConstructorButtonFromLkTest() {
        objProfilePage.waitForConstructorButton();
        objProfilePage.clickConstructorButton();
        String constructorText = objMainPage.getCreateBurgerText();
        assertThat(constructorText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверяем переход на главную страницу из ЛК кликом на лого")
    public void clickLogoFromLkTest() {
        objProfilePage.waitForLogo();
        objProfilePage.clickStellarLogo();
        String constructorText = objMainPage.getCreateBurgerText();
        assertThat(constructorText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Проверяем, что получилось перейти в профиль по клику на Личный кабинет")
    public void enterLkTest() {
        objProfilePage.waitForProfileButton();
        String profileText = objProfilePage.getAccountButtonText();
        assertThat(profileText, is("Профиль"));
    }





    @Test
    @DisplayName("Проверка выхода из ЛК по кнопке Выйти")
    public void logoutTest() {
        objProfilePage.waitForExitButton();
        objProfilePage.clickExitButton();
        objLoginPage.expectEnterText();
        String getEnterText = objLoginPage.getEnterText();
        assertThat(getEnterText, is("Вход"));
    }

    @After
    public void teardown() {
        driver.quit();
    }




}
