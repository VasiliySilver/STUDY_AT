package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample2Test {
    public WebDriver driver; // Переменная драйвера
    public String baseUrl = "http://demo.guru99.com/test/login.html"; //URL init
    String expectedTitle = "Successfully Logged in...";
    String actualTitle;

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void sample2Test() {
        // Находим email по id
        WebElement email = driver.findElement(By.id("email"));
        // Находим пароль по id
        WebElement password = driver.findElement(By.name("passwd"));

        // отправляем данные в поля формы авторизации
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefgh");

        // удаляем значения из полей авторизации
        email.clear();
        password.clear();

        //Находим кнопку которая будет отправлять значения
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        // кликаем по кнопке SIGN IN
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefgh");
        login.click();
        // проверяем удалось ли нам залогиниться
        actualTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @AfterClass
    public void CloseSite() {
        driver.close(); //Stopping driver
    }
}