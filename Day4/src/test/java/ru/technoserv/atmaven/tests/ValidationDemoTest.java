package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidationDemoTest {
    public WebDriver driver;
    public String baseUrl = "http://demo.guru99.com/V1/index.php";
    public String userValidationMessageActual;
    public String passwordValidationMessageActual;

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void validationDemoTest() {
        // Инициализация элементов страницы
        // имя пользователя
        WebElement usernameControl = driver.findElement(By.name("uid"));
        // пароль
        WebElement passwordControl = driver.findElement(By.name("password"));
        // сообщение валидации имени пользователя
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        // сообщение валидации пароля
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

        // клики по пустым полям формы
        usernameControl.click();
        passwordControl.click();
        usernameControl.click();

        // ждем появления стилей у элементов валидиции
        userValidationMessageActual = userValidationMessage.getAttribute("style");
        passwordValidationMessageActual = passwordValidationMessage.getAttribute("style");

        // Проверяем являются являются ли эти элементы видимыми
        Assert.assertEquals(userValidationMessageActual, "visibility: visible;");
        Assert.assertEquals(passwordValidationMessageActual, "visibility: visible;");

        // Заполняем поля формы
        usernameControl.sendKeys("user");
        passwordControl.sendKeys("password");

        // ждем появления стилей у элементов валидиции
        userValidationMessageActual = userValidationMessage.getAttribute("style");
        passwordValidationMessageActual = passwordValidationMessage.getAttribute("style");

        // проверяем являются ли эти элементы невидимыми
        Assert.assertEquals(userValidationMessageActual, "visibility: hidden;");
        Assert.assertEquals(passwordValidationMessageActual, "visibility: hidden;");
    }

    @AfterClass
    public void CloseSite() {
        driver.close();
    }
}
