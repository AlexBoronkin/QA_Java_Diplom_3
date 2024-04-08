package Praktikum.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {

    private  final WebDriver driver;

    // Локатор кнопки Войти
    private final By signInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти на форме восстановления пароля")
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

}
