package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Sample4Test {
    public WebDriver driver; // Переменная для драйвера
    public String baseUrl = "http://demo.guru99.com/test/yahoo.html"; //URL init
    public String wgetCommand; // Переменная в которой будет храниться команда wget

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver(); //ChromeDriver init
        wgetCommand = "wget -P /Users/LenaV/Downloads/test --no-check-certificate "; //Set wget command for download
        driver.get(baseUrl); //Get to URL
    }

    @Test
    public void sample4Test() {
        // Найти элемент по Id
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        // Получить страницу загрузки
        String sourceLocation = downloadButton.getAttribute("href");

        // Добавляем к нашей команде wget страницу загрузки
        wgetCommand += sourceLocation;

        // Пытаемся загрузить файл
        try {
            // Инициализируем процесс загрузки
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            // Получаем код завершения процесса
            int exitVal = exec.waitFor();
            // Инициализируем работу с файлом
            File f = new File("/Users/LenaV/Downloads/test/msgr11us.exe");
            // Проверяем существует ли файл
            Assert.assertTrue(f.exists());
            // Удаляем файл
            f.delete();
        } catch (InterruptedException | IOException ex) {
            //Если команда wget не работает
            throw new AssertionError(ex.toString());
        }
    }

    @AfterClass
    public void CloseSite() {
        driver.close(); // Останавливаем браузер
    }
}
