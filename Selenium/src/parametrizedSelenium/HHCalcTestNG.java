package parametrizedSelenium;

import static org.junit.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class HHCalcTestNG extends Assert
{
	public static WebDriver driver;

	@DataProvider
	public static Object[][] parameterTestNG() {
		return new Object[][] {
			{ FirefoxDriver.class },
			{ ChromeDriver.class },
			{ OperaDriver.class },			
		};
	}
	
	public HHCalcTestNG(Class driverClass) throws InstantiationException, IllegalAccessException 
	{
		driver = (WebDriver)driverClass.newInstance();
		driver.get("file:///d:/Java/ex_calk.html");
		
	}
	
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		System.setProperty("webdriver.opera.driver", "drivers//operadriver.exe");

	}

	public void endTest()
	{
		driver.close();
		driver.quit();
	}
	@Test(dataProvider = "parameterTestNG")
	public static void existTest(WebDriver driver)
	{
		boolean result=true;
		try {
			driver.findElement(By.id("btn1"));
			driver.findElement(By.id("btn2"));
			driver.findElement(By.id("btn3"));
			driver.findElement(By.id("btn4"));
			driver.findElement(By.id("btn5"));
			driver.findElement(By.id("btn6"));
			driver.findElement(By.id("btn7"));
			driver.findElement(By.id("btn8"));
			driver.findElement(By.id("btn9"));
			driver.findElement(By.id("btn0"));
			driver.findElement(By.id("btnplus"));
			driver.findElement(By.id("btnminus"));
			driver.findElement(By.id("btnumnog"));
			driver.findElement(By.id("btncount"));
			driver.findElement(By.id("btndevide"));
			driver.findElement(By.id("action"));
		} catch (NoSuchElementException e) {
			System.out.println(e);
			result=false;
		}
		assertEquals(true, result);
	}

	@Test
	public void simpleCheckTest() 
	{
		String res;
		try {
			driver.findElement(By.id("btn1")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("1", res);
			driver.findElement(By.id("txt1")).clear();
			
			driver.findElement(By.id("btn2")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("2", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn3")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("3", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn4")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("4", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn5")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("5", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn6")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("6", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn7")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("7", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn8")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("8", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn9")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("9", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btn0")).click();
			res = driver.findElement(By.id("txt1")).getAttribute("value");
			assertEquals("0", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btnplus")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("+", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btnminus")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("-", res);

			driver.findElement(By.id("btnumnog")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("*", res);

			driver.findElement(By.id("btncount")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("=", res);

			driver.findElement(By.id("btndevide")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("/", res);

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}	

	@Test
	public void testPlus() 
	{
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnplus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("108", res);
	}

	@Test
	public void testMinus() 
	{
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnminus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("-84", res);
	}

	@Test
	public void testUmnog() 
	{
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnumnog")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("60", res);
	}

	@Test
	public void testDevide() 
	{
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btndevide")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("3", res);
	}
}
