package Praktikum;

import Praktikum.dataForTests.BaseDate;
import Praktikum.pageObjects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.time.Duration;


public class MainPageTest {
    MainPage objHomePage;
    private WebDriver driver;
    WebDriverSelection chooseDriver = new WebDriverSelection();


    @Before
    public void setUp() {
        driver = chooseDriver.chooseYourBrowser("yandex");
        driver.navigate().to(BaseDate.BASE_URL);
        objHomePage = new MainPage(driver);

    }

    @Test
    @DisplayName("Проверяем переход в раздел Булки")
    public void bunSelectionTest() {
        objHomePage.clickFillingButton(); //снимаем предустановку с булок на всякий
        objHomePage.checkBunIsNotSelected();
        objHomePage.clickBunButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objHomePage.checkAttributeValueIfBunsSelected();
    }

    @Test
    @DisplayName("Проверяем переход в раздел Соусы")
    public void sauceSelectionTest() {
        objHomePage.checkSauceIsNotSelected();
        objHomePage.clickSauceButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objHomePage.checkAttributeValueIfSauceSelected();
    }

    @Test
    @DisplayName("Проверяем переход в раздел Начинки")
    public void fillingsSelectionTest() {
        objHomePage.checkFillingsIsNotSelected();
        objHomePage.clickFillingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objHomePage.checkAttributeIfFillingsSelected();
    }

    @After
    public void teardown() {
        driver.quit();
    }








}
