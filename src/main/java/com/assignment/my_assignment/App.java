package com.assignment.my_assignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
		/*
		 * Calculator calc = new Calculator(); int sum = calc.sum(10, 20); int diff =
		 * calc.diff(20, 10);
		 * 
		 * System.out.println("Sum is: " + sum); System.out.println("Difference is: " +
		 * diff);
		 */
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        //driver.get("https://www.facebook.com");
        driver.get("http://18.117.122.62:8081/contact.html");
        
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.findElement(By.name("your_name")).sendKeys("Sherin");
		
		driver.findElement(By.name("phone_number")).sendKeys("1234567890");
		
		driver.findElement(By.name("email_address")).sendKeys("testing@abc.com");
		
		driver.findElement(By.name("your_message")).sendKeys("This is amazing");
		
		driver.findElement(By.id("my-button")).click();
        
		//assert Result
		String message = driver.findElement(By.id("response")).getText();
			
		System.out.println(message);
        
        //Capture Screenshot
        TakesScreenshot scrshot = ((TakesScreenshot)driver);
        File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("insure-me-test.jpg");
        try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
        
        
        
        driver.quit();
        
        
    }
}
