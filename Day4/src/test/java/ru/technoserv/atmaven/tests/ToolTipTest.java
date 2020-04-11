package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolTipTest {

    public WebDriver driver; // Переменная под драйвер
    public String baseUrl = "http://demo.guru99.com/test/social-icon.html"; //URL адресс который тестируем
    public WebDriverWait wait; // объект ожидания
    public String expectedTooltip;

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver(); // инициализация ChromeDriver-а
        driver.get(baseUrl); // получить URL
        wait = new WebDriverWait(driver, 20); // объект ожидаия
        expectedTooltip = "Github"; // ожидаемая подсказка
    }

    @Test
    public void toolTipTest() {

        // находим иконку гитхаба на верху справа
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        // получаем значение атрибута title иконки github
        String actualTooltip = github.getAttribute("title");

        // проверяем является ли подсказка той которая нужна
        Assert.assertEquals(expectedTooltip, actualTooltip);

    }

    @AfterClass
    public void СloseSite() {
        driver.quit();
    }



}
