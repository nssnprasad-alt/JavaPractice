package com.test.selenium_demo;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import dev.failsafe.internal.util.Assert;

public class RahulShetty1 {
	
	@Test

    public static void cart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        
        Map<String, Integer> requiredVegetables = new HashMap<>();
        requiredVegetables.put("Carrot - 1 Kg",   1);
        requiredVegetables.put("Brocolli - 1 Kg",  1);
        requiredVegetables.put("Tomato - 1 Kg",    2);  

        List<WebElement> products = driver.findElements(
            By.xpath("//div[@class='products']//h4[@class='product-name']")
        );

        List<WebElement> addToCartButtons = driver.findElements(
            By.xpath("//div[@class='product']//button[text()='ADD TO CART']")
        );

        for (int i = 0; i < products.size(); i++) {

            String productName = products.get(i).getText();

            if (requiredVegetables.containsKey(productName)) {

                int quantity = requiredVegetables.get(productName); // 

                for (int q = 0; q < quantity; q++) {
                    addToCartButtons.get(i).click();  //
                    System.out.println("Added to cart: " + productName + " (click " + (q+1) + " of " + quantity + ")");
                }
            }
        }
        
        driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Place Order\"]")).click();
        
        WebElement country =driver.findElement(By.xpath("//select"));
        Select select = new Select(country);
        select.selectByVisibleText("India");
        
        driver.findElement(By.xpath("//input[@class=\"chkAgree\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Proceed\"]")).click();
        
//        WebElement msg = driver.findElement(By.xpath("//div[@class='wrapperTwo']/span"));
//        String actualMessage = msg.getText();
//
//        String expectedMessage = "Thank you, your order has been placed successfully";
//        Assert.assertEquals(actualMessage, expectedMessage);
        
        driver.quit();


    }
}