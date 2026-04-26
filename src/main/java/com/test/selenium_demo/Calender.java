package com.test.selenium_demo;

import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
	@Test
	public void calen() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://proleed.academy/exercises/selenium/hotel-reservation-form-for-practice.php");
//		driver.findElement(By.linkText("Drag and Drop"));
//		driver.findElement(By.xpath("//a[@href=\"/drag_and_drop\"]")).click();
		
		WebElement checkIn = driver.findElement(By.id("checkindate"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Setting the value directly
		js.executeScript("arguments[0].setAttribute('value', '2024-08-15')", checkIn);
		
	}

}
