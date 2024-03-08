package com.udemy.seleniumdesign.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest()
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        /*
         * options.addArguments("--lang=fr");
         * options.addArguments("--lang=ar-SA");
         */

        options.addArguments("--user-data-dir=C://Users//maxis//AppData//Local//Google//Chrome//User Data 2");
        options.addArguments("--profile-directory=Selenium");
        options.addArguments("--start-maximized");
      
        this.driver = new ChromeDriver(options);

        // this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
