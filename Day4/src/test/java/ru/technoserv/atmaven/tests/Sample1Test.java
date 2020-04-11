package ru.technoserv.atmaven.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample1Test {
    public WebDriver driver; //Driver init
    public String baseUrl = "http://demo.guru99.com/test/newtours/"; //URL init

    @BeforeClass
    public void OpenSite() {
        driver = new ChromeDriver(); //ChromeDriver init
        driver.get(baseUrl); //Get to URL
    }

    @Test
    public void AlertDemo() {

        // Проверяем пустой ли у нас title
        Assert.assertFalse(driver.getTitle().isEmpty(), "Title is empty");
        // Проверяем соответствие значения title
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

    }

    @AfterClass
    public void CloseSite() {
        driver.close(); //Stopping driver
    }
}