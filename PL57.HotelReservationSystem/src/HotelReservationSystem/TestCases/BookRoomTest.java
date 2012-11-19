package HotelReservationSystem.TestCases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BookRoomTest {

	@Test
	public void TestRoomTypeNotAvailable() throws InterruptedException, IOException
	{
		
		/*WebDriver driver = new FirefoxDriver();			
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/roomtypesServlet");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("aaa");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("aaa");
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		
		assertEquals("Type of Room selected not available",driver.findElement(By.id("roomstatus")).getText());

        
        //Close the browser
        driver.quit();*/
	}
	
	@Test
	public void TestDateConflict() throws InterruptedException, IOException
	{
		
	/*	WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/login.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='arrival']")).sendKeys("smiley");
		driver.findElement(By.xpath("//*[@name='departure']")).sendKeys("pass");
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		assertEquals("Room not available during this period",driver.findElement(By.id("roomstatus")).getText());
	
        
        //Close the browser
        driver.quit();*/
	}
	
	@Test
	public void TestBookSuccess() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/roomtypesServlet");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='arrival]")).click();
		driver.findElement(By.xpath("//*[@name='departure']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Check Room Availability')]")).click();
		
		assertEquals("Royal Stags Hotel: Guest Details",driver.getTitle());
	
        
        //Close the browser
        driver.quit();
	}
}
