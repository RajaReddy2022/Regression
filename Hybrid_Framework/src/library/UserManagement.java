package library;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.AppUtils;

public class UserManagement extends AppUtils
{
	public String fname;
	public void createNewUser(String fname,String email, String uname, String designation, String role, String frole,String dept ) throws InterruptedException
	{		
		List<WebElement> productlist = driver.findElements(By.tagName("img"));
		for(int k =0;k<productlist.size();k++)
		{
			String product= productlist.get(k).getAttribute("src");
			if(product.contains("user"))
			{
				productlist.get(k).click();
				break;
			}			
		}
		List<WebElement> blist = driver.findElements(By.tagName("button"));
		for(int m=0; m<blist.size(); m++)
		{
			String button = blist.get(m).getText();
			if(button.contains("Create"))
			{
				blist.get(m).click();
				break;
			}
		}
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("displayName")).sendKeys(uname);
		driver.findElement(By.name("designation")).sendKeys(designation);
		driver.findElement(By.id("demo-simple-select-outlined")).click();
		Thread.sleep(5000);
		List<WebElement> ddlist = driver.findElements(By.tagName("li"));
		for(int l=0; l<ddlist.size(); l++)
		{
			String ddown = ddlist.get(l).getText();
			if(ddown.equals(role))
			{
				ddlist.get(l).click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@id='Drawer']/div/div[2]/form/div[6]/div/div")).click();
		Thread.sleep(7000);
		List<WebElement> dropdowndlist = driver.findElements(By.tagName("li"));
		for(int o =0;o<dropdowndlist.size(); o++)
		{
			String ddown = dropdowndlist.get(o).getText();
			if(ddown.equals(frole))
			{
				dropdowndlist.get(o).click();
				break;
			}
		}
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/div/div[2]/form/div[7]/div/div/div")).click();
		Thread.sleep(3000);
		List<WebElement> ddlist2 = driver.findElements(By.tagName("li"));
		for(int o =0;o<ddlist2.size(); o++)
		{
			String ddown = ddlist2.get(o).getText();
			if(ddown.equals(dept))
			{
				ddlist2.get(o).click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@id='Drawer']/div/div[2]/form/div[8]/button/span[1]")).click();
	}	
	
	public boolean isUsercreatedSuccessfully(String fname) throws InterruptedException
	{
		Thread.sleep(5000);
		int paginationsize = driver.findElements(By.xpath("//nav/ul/li")).size();
		//System.out.println(paginationsize);
		boolean flag =false;
		List<String> usernames = new ArrayList<String>();
		for(int i=1; i<paginationsize; i++)
		{
				String paginationSelector = "//nav/ul/li["+i+"]";
				driver.findElement(By.xpath(paginationSelector)).click();
				Thread.sleep(2000);
				List<WebElement> nameselements = driver.findElements(By.xpath("//tr/td[2]"));
				for (WebElement namesElement : nameselements) 
				{
					usernames.add(namesElement.getText());
				}
		}
		for (String uname : usernames) 
		{
				//System.out.println(name);
				if(uname.contains(fname))
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
}
