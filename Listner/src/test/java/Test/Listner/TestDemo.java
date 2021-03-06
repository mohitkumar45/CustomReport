package Test.Listner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListners.class)
public class TestDemo
{
	@Test(priority=1)
	public void getTitle()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91975\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.print(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Google");
		Reporter.log("[Info] : Title is Matched ");
		
	}
	@Test
	public void getFail()
	{
		System.out.println("This test is Dummy Test");
		Assert.assertTrue(true);
		Reporter.log("[Info] : Test Case is Faild ");

		
	}
	@Test(dependsOnMethods={"getFail"} )
	public void getSkip()
	{
		System.out.print("This is Dummy test for Skip");
		Reporter.log("[Info] : Test Case is Skiped ");

	}

}
