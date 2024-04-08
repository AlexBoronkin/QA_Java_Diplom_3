package Praktikum.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;
    private final By accountButton = By.xpath("//*[text()='Профиль']");
    private final By orderListButton = By.xpath("//*[text()='История заказов']");
    private final By exitButton = By.xpath("//*[text()='Выход']");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");
    private final By stellarLogo = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидаем появления кнопки Выход")
    public void waitForExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    @Step("Ожидаем появления кнопки Конструктор")
    public void waitForConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
    }

    @Step("Ожидаем появления лого StellarBurgers")
    public void waitForLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(stellarLogo));
    }

    @Step("Ожидаем появления кнопки Профиль")
    public void waitForProfileButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(accountButton));
    }

    @Step("Получаем текст Профиль")
    public String getAccountButtonText() {
        return driver.findElement(accountButton).getText();
    }

    @Step("Нажимаем кнопку выход")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Нажимаем кнопку История заказов")
    public void clickOrderListButton() {
        driver.findElement(orderListButton).click();
    }

    @Step("Нажимаем на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажимаем на логотип")
    public void clickStellarLogo() {
        driver.findElement(stellarLogo).click();
    }




}
