package HotelReservationSystem.TestCases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckOutTest {

	@Test
	public void TestCheckOutSuccess() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/CheckOut.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='CheckInId']")).sendKeys("10");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Royal Stags Hotel : Check Out Successful",driver.getTitle());
	
        
        //Close the browser
        driver.quit();
	}
	
	@Test
	public void TestCheckOutFail() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/CheckOut.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='CheckInId']")).sendKeys("99");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Royal Stags Hotel : Invalid Check Out",driver.getTitle());
	
        
        //Close the browser
        driver.quit();
	}

}
