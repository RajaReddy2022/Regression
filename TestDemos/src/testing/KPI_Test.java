package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.AppUtils;

public class KPI_Test extends AppUtils
{
	@Test
	public void testKPICreation() throws InterruptedException 	
	{
		driver.findElement(By.xpath("//*[@id='Form Container']/div[1]/div[2]")).click();
		driver.findElement(By.name("email")).sendKeys("Testing_Hyd@email.com");
		driver.findElement(By.name("password")).sendKeys("xFlow@321");
		driver.findElement(By.xpath("//*[@id='Form Container']/div[3]/button[2]")).click();
		driver.findElement(By.xpath("//div[9]/div[1]/img")).click();
		driver.findElement(By.xpath("//div[2]/button")).click();
		
		driver.findElement(By.name("displayName")).sendKeys("KPI_6");
		driver.findElement(By.id("demo-simple-select-outlined")).click();
		Thread.sleep(3000);
		List<WebElement> dlist1 = driver.findElements(By.tagName("li"));
		for(int i=0;i<dlist1.size(); i++)
		{
			String dropdown = dlist1.get(i).getText();
			if(dropdown.contains("kpi"))
			{
				dlist1.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/div/div[2]/div[3]/form/div[3]/div/div/div")).click();
		Thread.sleep(3000);
		List<WebElement> dlist2 = driver.findElements(By.tagName("li"));
		for(int j=0; j<dlist2.size(); j++)
		{
			String dropdown = dlist2.get(j).getText();
			//System.out.println(dropdown);
			if(dropdown.equals("Measure"))
			{
				dlist2.get(j).click();
				break;
			}			
		}
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/div/div[2]/div[3]/form/div[4]/div/div/div")).click();
		Thread.sleep(3000);
		List<WebElement> dlist3 = driver.findElements(By.xpath("//div[3]/ul/li"));
		for(int l=0; l<dlist2.size(); l++)
		{
			String dropdown = dlist3.get(l).getText();
			//System.out.println(dropdown);
			if(dropdown.contains("Higher"))
			{
				dlist3.get(l).click();
				break;
			}			
		}
		driver.findElement(By.name("goalValue")).sendKeys("72");
		driver.findElement(By.name("metCriteriaPct")).sendKeys("95");
		driver.findElement(By.name("baselineValue")).sendKeys("NA");
		
		driver.findElement(By.xpath("//div[8]/div/div/div")).click();
		Thread.sleep(3000);
		List<WebElement> dlist4 = driver.findElements(By.xpath("//div[2]/div[3]/ul/li"));
		for(int m=1; m<dlist4.size(); m++)
		{
			String dropdown = dlist4.get(m).getText();
			System.out.println(dropdown);
			if(dropdown.equals("Management"))
			{
				dlist4.get(m).click();
				break;
			}
		}
		Thread.sleep(2000);

	}
}
