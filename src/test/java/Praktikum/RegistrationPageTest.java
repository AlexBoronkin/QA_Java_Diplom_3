package Praktikum;

import Praktikum.dataForTests.BaseDate;
import Praktikum.dataForTests.Login;
import Praktikum.dataForTests.Steps;
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
    MainPage objMainPage;
    RegistrationPage objRegistrationPage;
    LoginPage objLoginPage;

    WebDriverSelection chooseDriver = new WebDriverSelection();

    Steps steps;
    Login login;


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
        steps = new Steps();
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
        User user = new User("YaUstalTestirovatt@gmail.com", "12345678", "AAAAghjty");
        objRegistrationPage.registration(user.getName(), user.getEmail(), user.getPassword());
        login = new Login(user.getEmail(), user.getPassword());
        accessToken = steps.loginUser(login).extract().path("accessToken");

        objLoginPage.expectEnterText();
        String enterText = objLoginPage.getEnterText();
        assertThat(enterText, is("Вход"));

    }

    @After
    public void CleanUp() {
            steps.deleteUser(accessToken);
            driver.quit();
        }






}
