package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupDemoTest {
    public WebDriver driver; // Переменная под драйвер
    public String baseUrl = "http://demo.guru99.com/popup.php"; //URL адресс который тестируем
    public WebDriverWait wait; // объект ожидания
    public String mainWindow;
    public Boolean emptyField;


    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver(); // инициализация ChromeDriver-а
        driver.get(baseUrl); // получить URL
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        mainWindow = driver.getWindowHandle();
    }

    @Test
    public void popupDemo() {
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        // Получаем все новые открытые окна
        Set<String> allWindows=driver.getWindowHandles();

        // обходим все окна

        for (String childWindow : allWindows)
        {
            // Проверяем является ли эта вкладка главной
            if(!mainWindow.equalsIgnoreCase(childWindow))
            {
                // Если мы тут то это не основная вкладка
                // Переключаемся на вкладку
                driver.switchTo().window(childWindow);
                // Находим поле ввода Email и вводим e-mail
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                // отправляем данные, нажимаем на кнопку
                driver.findElement(By.name("btnLogin")).click();
                // ждем пока не появится таблица
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));
                // получаем ID
                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                // получаем пароль
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                // Проверяем есть ли доступ к таблице
                WebElement accessHeader = driver.findElement((By.xpath("/html/body/table/tbody/tr[1]/td/h2")));
                Assert.assertEquals(accessHeader.getText(), "Access details to demo site.");

                //Проверяем пустой ли userId или нет
                emptyField = userIdElement.getText().isEmpty();
                Assert.assertFalse(emptyField);

                //Проверяем пустой ли пароль
                emptyField = passwordElement.getText().isEmpty();
                Assert.assertFalse(emptyField);

                // Закрываем вкладку
                driver.close();

            }
        }
    }

    @AfterClass
    public void СloseSite() {
        // Возвращаемся в родительскую вкладку
        driver.switchTo().window(mainWindow);
        // Закрываем браузер
        driver.quit();
    }
}



