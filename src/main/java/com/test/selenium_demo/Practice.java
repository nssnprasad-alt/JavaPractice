package com.test.selenium_demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practice {
    @Test
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.getTitle());

        WebElement title = driver.findElement(By.xpath("//*[text()='Practice Page']"));
        String actualText = title.getText();
        System.out.println(actualText);

//        Assert.assertEquals(actualText, "Practice Page");
        driver.findElement(By.xpath("//input[@value=\"radio2\"]")).click();
     // Type in autocomplete
        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        // Click India from suggestions
        driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper' and text()='India']")).click();
        
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option3");
        
        WebElement element= driver.findElement(By.xpath("//legend[text()=\"Element Displayed Example\"]"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        
        String window = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//button[@id=\"openwindow\"]")).click();
        
       
      Set<String> handles  =driver.getWindowHandles();
      
      for(String handle: handles) {
    	 driver.switchTo().window(handle);
    	 if (driver.getCurrentUrl().contains("qaclickacademy")) {
    	        System.out.println("Switched to child window");
    	        System.out.println(driver.getTitle());
    	        break;
    	    }
    	 }
    
      
      driver.manage().window().maximize();
      
      TakesScreenshot ts = (TakesScreenshot) driver;

      File src = ts.getScreenshotAs(OutputType.FILE);
      File dest = new File("C:\\screenshots\\test.png");

      FileUtils.copyFile(src, dest);
//        
      driver.switchTo().window(window);
     String str = driver.getTitle();
     Assert.assertEquals(str, "Practice Page");
     driver.quit();
    }
}