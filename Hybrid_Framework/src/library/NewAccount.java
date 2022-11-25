package library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class NewAccount extends AppUtils
{
	public void createNewAccount(String adminuname,String lname,String cname,String adminrole,String adminemail,
			String mobNo,String adminpassword,String industry) throws InterruptedException
	{
		driver.findElement(By.name("firstName")).sendKeys(adminuname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("companyName")).sendKeys(cname);
		driver.findElement(By.name("role")).sendKeys(adminrole);
		driver.findElement(By.name("email")).sendKeys(adminemail);
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys(mobNo);
		driver.findElement(By.name("password")).sendKeys(adminpassword);
		driver.findElement(By.name("confirm password")).sendKeys(adminpassword);
		driver.findElement(By.xpath("//div[9]/div")).click();
		
		Thread.sleep(3000);		
		List<WebElement> dlist = driver.findElements(By.tagName("li"));
		for(int i=1; i<=dlist.size(); i++)
		{
			String dd = dlist.get(i).getText();
			if(dd.contains(industry))
			{
				dlist.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='radio' and @value='company']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[5]/button[2]")).click();
	}
		public boolean iSCreateAcWorking() throws InterruptedException
	{
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//ul//i")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
}
