package HotelReservationSystem.TestCases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckinTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCheckInSuccess() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/CheckInNew.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='Pnr']")).sendKeys("45166");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Hotel Royal Stags : Check In Successful",driver.getTitle());
	
        
        //Close the browser
        driver.quit();
	}
	
	@Test
	public void TestCheckInFail() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/CheckInNew.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='Pnr']")).sendKeys("451786");
		
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		
		assertEquals("Hotel Royal Stags : Invalid Reservation!!",driver.getTitle());
	
        
        //Close the browser
        driver.quit();
	}

}
