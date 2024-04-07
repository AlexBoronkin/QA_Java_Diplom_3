package Praktikum.pageObjects;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.not;

public class MainPage {

    private final WebDriver driver;

    // Дальше идет блок с локаторами
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By loginAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By ordersButton = By.xpath("//p[contains(text(),'Лента Заказов')]");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");
    private final By bunButton = By.xpath("//span[text()='Булки']//parent::div");
    private final By sauceButton = By.xpath("//span[text()='Соусы']//parent::div");
    private final By fillingButton = By.xpath("//span[text()='Начинки']//parent::div");
    private final By createBurgerText = By.xpath("//*[text()='Соберите бургер']");
    private final String TAB_SELECTED_ATTRIBUTE = "tab_tab_type_current";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку Личный кабинет")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    @Step("Нажать на булки")
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step("Нажать на соусы")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Нажать на начинки")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Получаем текст Соберите бургер")
    public String getCreateBurgerText() {
        return driver.findElement(createBurgerText).getText();
    }

    @Step("Ожидаем кнопку Личный кабинет, чтобы точно кликалась")
    public void expectPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(accountButton));
    }

    // Дальше делаем методы проверки выбранного таба через текст в классе. Нужно чтобы в локаторе был текст "tab_tab_type_current"

    @Step("Проверяем, что у элемента Булки есть в токаторе \"tab_tab_type_current\"")
    public void checkAttributeValueIfBunsSelected() {
        MatcherAssert.assertThat(driver.findElement(bunButton).getAttribute("class"),containsString(TAB_SELECTED_ATTRIBUTE));
    }

    @Step("Проверяем, что у элемента Соусы есть в токаторе \"tab_tab_type_current\"")
    public void checkAttributeValueIfSauceSelected() {
        MatcherAssert.assertThat(driver.findElement(sauceButton).getAttribute("class"),containsString(TAB_SELECTED_ATTRIBUTE));
    }

    @Step("Проверяем, что у элемента Начинки есть в токаторе \"tab_tab_type_current\"")
    public void checkAttributeIfFillingsSelected() {
        MatcherAssert.assertThat(driver.findElement(fillingButton).getAttribute("class"),containsString(TAB_SELECTED_ATTRIBUTE));
    }

    @Step("Проверка, что таб Булки не выбран")
    public void checkBunIsNotSelected() {
        MatcherAssert.assertThat(driver.findElement(bunButton).getAttribute("class"),not(containsString(TAB_SELECTED_ATTRIBUTE)));
    }

    @Step("Проверка, что таб Соусы не выбран")
    public void checkSauceIsNotSelected() {
        MatcherAssert.assertThat(driver.findElement(sauceButton).getAttribute("class"),not(containsString(TAB_SELECTED_ATTRIBUTE)));
    }

    @Step("Проверка, что таб Начинки не выбран")
    public void checkFillingsIsNotSelected() {
        MatcherAssert.assertThat(driver.findElement(fillingButton).getAttribute("class"),not(containsString(TAB_SELECTED_ATTRIBUTE)));
    }





}
