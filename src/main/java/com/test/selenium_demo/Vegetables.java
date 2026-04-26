package com.test.selenium_demo;
import java.time.Duration;

import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vegetables {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        // ✅ Add all vegetables you want here
        List<String> requiredVegetables = Arrays.asList(
            "Carrot - 1 Kg",
            "Brocolli - 1 Kg",
            "Tomato - 1 Kg"
        );

        List<WebElement> products = driver.findElements(
            By.xpath("//div[@class='products']//h4[@class='product-name']")
        );

        List<WebElement> addToCartButtons = driver.findElements(
            By.xpath("//div[@class='product']//button[text()='ADD TO CART']")
        );
        for (int i = 0; i < products.size(); i++) {

            String productName = products.get(i).getText();

            if (requiredVegetables.contains(productName)) {  // ✅ Check against the list
                addToCartButtons.get(i).click();
                System.out.println("Added to cart: " + productName);
            }
        }

	}

}
