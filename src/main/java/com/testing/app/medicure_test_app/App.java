package com.testing.app.medicure_test_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
		//Initializing the ChromeDriver
		WebDriver driver = new ChromeDriver(options);
		
		//Opening the web application
        driver.get("http://3.220.4.2:8082");
        //Thread.sleep(2000);
        //Reading the title
        String title = driver.getTitle();
        System.out.println(title);
        
        //defining the timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        Thread.sleep(2000);
        //Locate the New Contact
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("/html/body/div/header/div/nav/div/ul/li[5]/a"));
        action.moveToElement(element).click().build().perform();
        
        
        //WebElement newContact = driver.findElement(By.className("v-button-wrap"));
        //newContact.click();
        
        WebElement name =driver.findElement(By.cssSelector("input[placeholder='Your Name']"));
        name.sendKeys("Manoj Shanmugham");
        System.out.println(name);
        //Thread.sleep(2000);
        
        WebElement phone_number =driver.findElement(By.cssSelector("input[placeholder='Phone Number']"));
        phone_number.sendKeys("123456");
        System.out.println(phone_number);
        //Thread.sleep(2000);
        
        WebElement email =driver.findElement(By.cssSelector("input[placeholder='Email']"));
        email.sendKeys("abc@gmail.com");
        System.out.println(email);
        //Thread.sleep(2000);
        
        WebElement send_message =driver.findElement(By.cssSelector("input.message-box[placeholder='Message']"));
        send_message.sendKeys("This is a test message");
        System.out.println(send_message);
        //Thread.sleep(2000);
        
        WebElement sendButton = driver.findElement(By.cssSelector("div.btn_box > button"));
        sendButton.click();
        
        WebElement checkMessage = driver.findElement(By.id("message"));
        String message = checkMessage.getText();
        Thread.sleep(2000);
        
        if(message.equals("Email sent.")) {
        	System.out.println("Test Passed");
        }
        else {
        	System.out.println("Test Failed");
        }
   
        Thread.sleep(2000);
        driver.quit();
    }
}
