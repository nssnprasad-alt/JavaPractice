package com.test.selenium_demo;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShetty {
	
	

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(
            By.xpath("//div[@class='products']//h4[@class='product-name']")
        );

        for (int i = 0; i < products.size(); i++) {  // Fix 1: > changed to 

            if (products.get(i).getText().equals("Carrot - 1 Kg")) {  // Fix 2: get text of each element

                // Fix 3: Click the ADD TO CART button for this specific product
                driver.findElements(By.xpath("//div[@class='product']//button[text()='ADD TO CART']"))
                      .get(i)
                      .click();  // Fix 4: added .click()
                break; // Stop loop once carrot is found and added
            }
        }
    }
}