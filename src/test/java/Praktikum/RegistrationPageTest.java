package Praktikum;

import Praktikum.dataForTests.BaseDate;
import Praktikum.dataForTests.User;
import Praktikum.pageObjects.LoginPage;
import Praktikum.pageObjects.MainPage;
import Praktikum.pageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationPageTest {

    private WebDriver driver;
    protected String accessToken;
    User user;
    MainPage objMainPage;
    RegistrationPage objRegistrationPage;
    LoginPage objLoginPage;
    WebDriverSelection chooseDriver = new WebDriverSelection();

    @Before
    public void setUp() {
        driver = chooseDriver.chooseYourBrowser("chrome");
        driver.navigate().to(BaseDate.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objMainPage = new MainPage(driver);
        objMainPage.clickAccountButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationButton();
        objRegistrationPage = new RegistrationPage(driver);
    }


    @Test
    @DisplayName("Проверяем ошибку с некорректным паролем")
    public void createUserWithWrongPasswordTest() {
        objRegistrationPage.registration("Alex", "boronkin@gmail.com", "1234");
        String getErrorText = objRegistrationPage.getErrorText();
        assertThat(getErrorText, is("Некорректный пароль"));
    }

    @Test
    @DisplayName("Проверяем корректную успешную регистрацию")
    public void createUserCorrectTest() {
        objRegistrationPage.registration("Telep", "tetivochka@yandex.ru", "1234567");
        objLoginPage.expectEnterText();
        String enterText = objLoginPage.getEnterText();
        assertThat(enterText, is("Вход"));
    }

    @After
    public void teardown() {
        driver.quit();
    }






}
