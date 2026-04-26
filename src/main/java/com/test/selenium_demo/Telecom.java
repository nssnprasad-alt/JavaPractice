package com.test.selenium_demo;

import java.time.Duration;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Telecom {
	
	

    public static void main(String[] args) {

        String item = "Phone Cover";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@href=\"/electronics\"]"))).build().perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@href=\"/cell-phones\"]"))).click().perform();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-item']"));

        for (WebElement product : products) {

            String name = product.findElement(By.xpath(".//h2[@class='product-title']")).getText();

            if (name.equalsIgnoreCase(item)) {
                // ✅ Fix 1: Use relative XPath (.// instead of //) to click THIS product's button
                product.findElement(By.xpath(".//input[@value='Add to cart']")).click();
                break;
            }
        }

          driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-80\"]")).click();
        action.moveToElement(driver.findElement(By.xpath("//span[text()=\"Shopping cart\"]"))).click().perform();

        WebElement element = driver.findElement(By.xpath("//select[@id=\"CountryId\"]"));
        Select select = new Select(element);
        select.selectByVisibleText("India");
        driver.findElement(By.xpath("//input[@id=\"termsofservice\"]")).click();
        driver.findElement(By.xpath("//button[@name=\"checkout\"]")).click();
       WebElement text =driver.findElement(By.xpath("//h1"));
        
        Assert.assertEquals(text, "Welcome, Please Sign In!");
    }
}