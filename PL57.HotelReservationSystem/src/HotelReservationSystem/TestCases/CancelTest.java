package HotelReservationSystem.TestCases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CancelTest {

	@Test
	public void TestCancelSuccess() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/cancelReservation.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='pnr']")).sendKeys("45166");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Reservation Cancelled Successfully!!!",driver.findElement(By.id("errormsg")).getText());
	
        
        //Close the browser
        driver.quit();
	}
	
	@Test
	public void TestCancelDateFail() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/cancelReservation.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='pnr']")).sendKeys("46945");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Sorry Unable To Cancel!!!! Date Has Crossed your Arrival Date!!!",driver.findElement(By.id("errormsg")).getText());
        
        //Close the browser
        driver.quit();
	}

}
