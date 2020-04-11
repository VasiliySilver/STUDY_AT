package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Sample3Test {
    public WebDriver driver;
    public String baseUrl = "http://demo.guru99.com/test/upload/";
    public WebDriverWait wait;

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl); //Get to URL
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void UploadFileDemo() {
        // Находим загрузочную кнопку
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // Вводим путь до файла который будем загружать
        uploadElement.sendKeys("C:\\Users\\LenaV\\Downloads\\test\\wget-latest.tar.gz");

        // Ставим галочку что соглашаемся с политикой сервиса
        driver.findElement(By.id("terms")).click();

        // Получить селектор сообщения об успехе
        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));

        // Кликаем на кнопку загрузить файл UploadFile
        driver.findElement(By.name("send")).click();

        // Ждем загрузку
        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        // Проверяем успешность загрузки
        Assert.assertTrue(resultText.getText().contains(" successfully"));
    }

    @AfterClass
    public void CloseSite() {
        driver.close();
    }
}