package com.test.selenium_demo;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {
    
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://orangehrm.com/30-day-free-trial");

        // ✅ STEP 1: Switch to iframe
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        // ✅ STEP 2: Fill form inside iframe
        driver.findElement(By.xpath("//input[contains(@placeholder,'username')]"))
              .sendKeys("NavyaNallam");

        driver.findElement(By.xpath("//input[contains(@placeholder,'Full Name')]"))
              .sendKeys("NavyaPrasadNallam");

        driver.findElement(By.xpath("//input[contains(@placeholder,'Work Email')]"))
              .sendKeys("abc@gmail.com");

        driver.findElement(By.xpath("//input[contains(@placeholder,'Phone')]"))
              .sendKeys("9618912714");

        // Country dropdown
        WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
        Select sel = new Select(country);
        sel.selectByVisibleText("India");

        // ❌ CAPTCHA cannot be automated
        System.out.println("CAPTCHA is inside iframe / protected - cannot automate");

        // Optional: submit button (if enabled)
        driver.findElement(By.xpath("//input[@name='action_submitForm']"))
              .click();

        // 🔁 STEP 3: Switch back to main page
        driver.switchTo().defaultContent();

        driver.quit();
    }
}