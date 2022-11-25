package library;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class KPIManagement extends AppUtils
{
	public void createKPI(String kpiname, String metric_type,
			String metric_category,String is_Higher_Better,String goal, String metric_criteria, String baseline,
			String department) throws InterruptedException
	{
		List<WebElement> productlist = driver.findElements(By.tagName("img"));
		//System.out.println(productlist.size());
		for(int k =0;k<productlist.size();k++)
		{
			String product= productlist.get(k).getAttribute("src");
			//System.out.println(product);
			if(product.contains("business"))
			{
				productlist.get(k).click();
				break;
			}			
		}
		driver.findElement(By.xpath("//div[2]/button")).click();
		driver.findElement(By.name("displayName")).sendKeys(kpiname);
		driver.findElement(By.id("demo-simple-select-outlined")).click();
		Thread.sleep(3000);
		List<WebElement> dlist1 = driver.findElements(By.tagName("li"));
		for(int i=0;i<dlist1.size(); i++)
		{
			String dropdown = dlist1.get(i).getText();
			if(dropdown.contains(metric_type))
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
			if(dropdown.equals(metric_category))
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
			if(dropdown.contains(is_Higher_Better))
			{
				dlist3.get(l).click();
				break;
			}			
		}
		driver.findElement(By.name("goalValue")).sendKeys(goal);
		driver.findElement(By.name("metCriteriaPct")).sendKeys(metric_criteria);
		driver.findElement(By.name("baselineValue")).sendKeys(baseline);
		driver.findElement(By.xpath("//div[8]/div/div/div")).click();
		Thread.sleep(5000);
		List<WebElement> dlist4 = driver.findElements(By.xpath("//div[2]/div[3]/ul/li"));
		for(int m=1; m<dlist4.size(); m++)
		{
			String dropdown = dlist4.get(m).getText();
			if(dropdown.contains(department))
			{
				dlist4.get(m).click();
				break;
			}
		}
		driver.findElement(By.className("MuiButton-label")).click();
	}
	public boolean isCreateNewTopicWorking(String expname) throws InterruptedException
	{
		int paginationsize = driver.findElements(By.xpath("//nav/ul/li")).size();
		//System.out.println(paginationsize);
		boolean flag =false;
		List<String> kpinames = new ArrayList<String>();
		for(int i=1; i<paginationsize; i++)
		{
				String paginationSelector = "//nav/ul/li["+i+"]";
				driver.findElement(By.xpath(paginationSelector)).click();
				Thread.sleep(2000);
				List<WebElement> nameselements = driver.findElements(By.xpath("//tr/td[2]"));
				for (WebElement namesElement : nameselements) 
				{
					kpinames.add(namesElement.getText());
				}
		}
		for (String actname : kpinames) 
		{
				//System.out.println(name);
				if(actname.contains(expname))
				{
					flag = true;
					break;
				}
		}
		if(flag)
		{
			return false;
		}else
			{
				return false;
			}
	}
}
