package parametrizedSelenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class HHCalcTestNG {
	WebDriver driver=null;
	@Factory(dataProvider = "dataMethod")
	public HHCalcTestNG(WebDriver driver) {
		this.driver=driver;
	}

	@DataProvider
	public static Object[][] dataMethod() {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		System.setProperty("webdriver.opera.driver", "drivers//operadriver.exe");
		return new Object[][] { 
			{ new FirefoxDriver()},
			{ new OperaDriver()},
			{ new ChromeDriver() }
		};
	}
	
	@AfterClass
	public void endClass()
	{
		driver.close();
		driver.quit();
	}

	@Test
	public void existTest()
	{
		driver.get("file:///d:/Java/ex_calk.html");
		assertEquals(true, driver.findElement(By.id("btn1")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn2")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn3")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn4")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn5")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn6")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn7")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn8")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn9")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btn0")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btnplus")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btnminus")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btnumnog")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btncount")).isEnabled());
		assertEquals(true, driver.findElement(By.id("btndevide")).isEnabled());
		assertEquals(true, driver.findElement(By.id("action")).isEnabled());
		assertEquals(true, driver.findElement(By.id("txt1")).isEnabled());
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
			driver.findElement(By.id("txt1")).clear();
			
			driver.findElement(By.id("btnumnog")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("*", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btncount")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("=", res);
			driver.findElement(By.id("txt1")).clear();

			driver.findElement(By.id("btndevide")).click();
			res = driver.findElement(By.id("action")).getAttribute("value");
			assertEquals("/", res);
			driver.findElement(By.id("txt1")).clear();

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
		AssertJUnit.assertEquals("108", res);
		driver.findElement(By.id("txt1")).clear();
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
		AssertJUnit.assertEquals("-84", res);
		driver.findElement(By.id("txt1")).clear();
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
		AssertJUnit.assertEquals("60", res);
		driver.findElement(By.id("txt1")).clear();
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
		AssertJUnit.assertEquals("3", res);
		driver.findElement(By.id("txt1")).clear();
	}
}

