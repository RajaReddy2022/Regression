package library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class LoginPage extends AppUtils
{
	
	public void login(String uid, String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='Form Container']/div[1]/div[2]")).click();
		driver.findElement(By.name("email")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@id='Form Container']/div[3]/button[2]")).click();
		Thread.sleep(3000);
	}
	public boolean isLoginWorking() throws InterruptedException
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa-user-circle')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sc-iwsKbI')]")).click();
		List<WebElement> plist = driver.findElements(By.xpath("//p[2]"));
		boolean flag = false;
		for(int k=0;k<plist.size();k++)
		{
			String user = plist.get(k).getText();
			if(user.contains("Testing_Hyd"))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public boolean logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/div[10]/div[1]/i")).click();
		Thread.sleep(2000);
		String cururl = driver.getCurrentUrl();
		if(cururl.contains("login"))
		{
			return true;
		}else
		{
			return false;
		}
		
	}
}
