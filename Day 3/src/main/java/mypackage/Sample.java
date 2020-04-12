package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Sample {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
//        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
//        System.setProperty("webdriver.chrome.driver","\\Users\\LenaV\\IdeaProjects\\Day 3\\drivers\\chromedriver.exe");
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new OperaDriver();


        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        driver.get(baseUrl);

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}