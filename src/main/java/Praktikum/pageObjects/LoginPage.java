package Praktikum.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;


    //Локатор поля имейл
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");

    //Локатор поля пароль
    private final By passwordField = By.xpath("//input[@type='password']");

    //Локатор кнопки Войти
    private final By enterButton = By.xpath("//*[text()='Войти']");

    //Локатор кнопки Зарегистрироваться
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");

    //Локатор кнопки Восстановить пароль
    private final By forgotPasswordButton = By.xpath("//*[text()='Восстановить пароль']");

    //Локатор текста Вход, для понимания, что мы на странице
    private final By enterText = By.xpath("//h2[contains(text(),'Вход')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидаем, что заголовок Вход виден")
    public void expectEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(enterText));
    }

    @Step("Получить текст Вход")
    public String getEnterText() {
        return driver.findElement(enterText).getText();
    }

    @Step("Заполняем поле email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажать кнопку Восстановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Объединяем шаги в один метод авторизации")
    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickEnterButton();
    }


}
