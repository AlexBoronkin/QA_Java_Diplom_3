package Praktikum.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    private final By inputName = By.xpath("//label[contains(text(),'Имя')]/../input");
    private final By inputEmail = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By inputPassword = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//*[text()='Войти']");
    private final By errorText = By.xpath("//*[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполняем поле Имя")
    public void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Заполняем поле Email")
    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполняем поле Пароль")
    public void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Получаем текст ошибки Некорректный пароль")
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    @Step("Метод регистрации пользователя полный")
    public void registration(String name, String email, String password) {
        setInputName(name);
        setInputEmail(email);
        setInputPassword(password);
        clickRegisterButton();
    }




}
