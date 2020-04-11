package ru.technoserv.atmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Sample1 {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";


        chromeDriver.get(baseUrl);

        System.out.println("Chrome title = " + chromeDriver.getTitle());
//        chromeDriver.quit();

    }
}
