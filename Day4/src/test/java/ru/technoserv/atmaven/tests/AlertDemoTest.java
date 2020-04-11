package ru.technoserv.atmaven.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertDemoTest {
            public WebDriver driver; // Переменная под драйвер
            public String baseUrl = "http://demo.guru99.com/test/delete_customer.php"; //URL адресс который тестируем
            public WebDriverWait wait; // объект ожидания

            @BeforeClass
            public void OpenSite() {
                driver = new ChromeDriver(); // инициализация ChromeDriver-а
                driver.get(baseUrl); // получить URL
                wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void AlertDemo() {
        // Находим поле ввода и заполянем значением
        driver.findElement(By.name("cusid")).sendKeys("53920");
        // Находим кнопку и кликаем чтобы отправить наши данные
        driver.findElement(By.name("submit")).click();

        // Первй alert(предупреждающее окно)
        // Ожидаем появление этого alert окна
        wait.until(ExpectedConditions.alertIsPresent());
        //  Переключаеся на окно Alert(диалоговое окно)
        Alert alert = driver.switchTo().alert();
        // Получаем сообщение из диалогового окна
        String alertMessage = alert.getText();
        // Проверяем сообщение
        Assert.assertEquals("Do you really want to delete this Customer?", alertMessage);
        // Нажимаем ОК в диалоговом окне
        alert.accept();

        // Второе диалоговое окно
        //Ждем его появления
        wait.until(ExpectedConditions.alertIsPresent());
        // Переключаемся на это окно
        Alert alert2 = driver.switchTo().alert();
        // Получаем сообщений из alert-а
        String alertMessage2 = alert2.getText();
        // Проверяем сообщение
        Assert.assertEquals("Customer Successfully Delete!", alertMessage2);
        // Нажимаем ок в окне сообщения
        alert.accept();
    }

    @AfterClass
    public void СloseSite() {
        driver.close(); //Stopping driver
    }
}