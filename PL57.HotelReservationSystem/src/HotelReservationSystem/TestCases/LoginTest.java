package HotelReservationSystem.TestCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void TestValidLogin() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/login.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("andy");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("andy");
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		
		assertEquals(driver.getTitle(),"Royal Stags Hotel : Receptionist home");

        
        //Close the browser
        driver.quit();
	}
	
	@Test
	public void TestInValidUsername() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/login.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("smiley");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("pass");
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		assertEquals("Username Does not exist",driver.findElement(By.id("errormsg")).getText());
	
        
        //Close the browser
        driver.quit();
	}
	
	@Test
	public void TestInValidPassword() throws InterruptedException, IOException
	{
		
		WebDriver driver = new FirefoxDriver();			
		
			
		driver.get("http://localhost:8080/PL57.HotelReservationSystem/login.jsp");
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("andy");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("pass");
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		assertEquals("Authentication Failure. Incorrect Username and Password",driver.findElement(By.id("errormsg")).getText());
	
        
        //Close the browser
        driver.quit();
	}
}
