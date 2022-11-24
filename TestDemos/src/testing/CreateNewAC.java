package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.AppUtils;

public class CreateNewAC extends AppUtils
{
	
	@Test	
	public void createNewAccount() throws InterruptedException
	{
		String uname = "Admin"; 
		String lname = "124";
		String cname = "ExFlow";
		String role = "Manager";
		String email = "Admin124@email.com";
		String mobNo = "919989465781";
		String password = "xFlow@321";
		String industry = "Lexis";
		
		driver.findElement(By.name("firstName")).sendKeys(uname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("companyName")).sendKeys(cname);
		driver.findElement(By.name("role")).sendKeys(role);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys(mobNo);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm password")).sendKeys(password);
		driver.findElement(By.xpath("//div[9]/div")).click();
		
		Thread.sleep(2000);		
		List<WebElement> dlist = driver.findElements(By.tagName("li"));
		for(int i=1; i<=dlist.size(); i++)
		{
			String dd = dlist.get(i).getText();
			System.out.println(dd);
			if(dd.contains(industry))
			{
				dlist.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//input[@type='radio' and @value='company']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[5]/button[2]")).click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//ul//i")).isDisplayed())
		{
			System.out.println("Pass");
		}else
		{
			System.out.println("Fail");
		}*/
		
	}
}
