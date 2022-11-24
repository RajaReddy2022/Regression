package testing;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.AppUtils;

public class Alert_Test extends AppUtils
{
	@Test
	public void alert() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='Form Container']/div[1]/div[2]")).click();
		driver.findElement(By.name("email")).sendKeys("Testing_Hyd@email.com");
		driver.findElement(By.name("password")).sendKeys("xFlow@323");
		driver.findElement(By.xpath("//*[@id='Form Container']/div[3]/button[2]")).click();
		//driver.findElement(By.xpath("//div[9]/div[1]/img")).click();
		//driver.findElement(By.xpath("//div[2]/button")).click();
		Thread.sleep(2000);
		String alert =  driver.switchTo().alert().getText();
		System.out.println(alert);
		if(alert.contains("Could not login"))
		{
			System.out.println("Pass");
		}else
		{
			System.out.println("Fail");
		}
	}
}
