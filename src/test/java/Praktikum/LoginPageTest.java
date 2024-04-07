package Praktikum;

import Praktikum.dataForTests.BaseDate;
import Praktikum.pageObjects.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Praktikum.dataForTests.BaseDate;

import java.time.Duration;

import static Praktikum.dataForTests.BaseDate.EMAIL_FOR_TEST;
import static Praktikum.dataForTests.BaseDate.PASSWORD_FOR_TEST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest {

    public static final String VALID_PROFILE = "Профиль";
    private WebDriver driver;
    MainPage objMainPage;
    RegistrationPage objRegistrationPage;
    LoginPage objLoginPage;
    ProfilePage objProfilePage;
    RecoveryPasswordPage objRecoveryPasswordPage;
    WebDriverSelection chooseDriver = new WebDriverSelection();

    @Before
    public void setUp() {
        driver = chooseDriver.chooseYourBrowser("chrome");
        driver.navigate().to(BaseDate.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objProfilePage = new ProfilePage(driver);
        objRegistrationPage = new RegistrationPage(driver);
        objRecoveryPasswordPage = new RecoveryPasswordPage(driver);

    }

    @Test
    @DisplayName("Проверка входа в аккаунт по кнопке Войти в аккаунт на главной")
    public void loginButtonMainPageTest() {
        objMainPage.clickLoginAccountButton();
        objLoginPage.login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        objMainPage.clickAccountButton();
        objProfilePage.waitForProfileButton();
        String accountButtonText = objProfilePage.getAccountButtonText();
        assertThat(accountButtonText, is(VALID_PROFILE));
    }

    @Test
    @DisplayName("Проверка входа в аккаунт по кнопке Личный кабинет")
    public void accountButtonLoginTest() {
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickAccountButton();
        objLoginPage.login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickAccountButton();
        String accountButtonText = objProfilePage.getAccountButtonText();
        assertThat(accountButtonText, is(VALID_PROFILE));
    }

    @Test
    @DisplayName("Проверка входа по кнопке Войти в форме регистрации")
    public void registrationPageLoginTest() {
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickLoginAccountButton();
        objLoginPage.clickRegistrationButton();
        objRegistrationPage.clickLoginButton();
        objLoginPage.login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickAccountButton();
        objProfilePage.waitForProfileButton();
        String accountButtonText = objProfilePage.getAccountButtonText();
        assertThat(accountButtonText, is(VALID_PROFILE));
    }

    @Test
    @DisplayName("Проверка входа по кнопке Войти в форме восстановления пароля")
    public void loginInForgotPasswordPageTest() {
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickLoginAccountButton();
        objLoginPage.clickForgotPasswordButton();
        objRecoveryPasswordPage.clickSignIn();
        objLoginPage.login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        objMainPage.expectPersonalAccountButton();
        objMainPage.clickAccountButton();
        objProfilePage.waitForProfileButton();
        String accountButtonText = objProfilePage.getAccountButtonText();
        assertThat(accountButtonText, is(VALID_PROFILE));
    }







    @After
    public void teardown() {
        driver.quit();
    }


}
