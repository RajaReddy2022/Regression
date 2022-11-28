package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import library.KPIManagement;
import library.LoginPage;
import library.NewAccount;
import library.UserManagement;
import utils.AppUtils;
import utils.XLUtils;

public class testcases extends AppUtils
{	
	
	String keywordfile = "D:\\TestData.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	
	@Test
	public void regressionTestcases() throws IOException, InterruptedException
	{
		//objects for Library Classes
		LoginPage lp = new LoginPage();
		UserManagement um = new UserManagement();
		KPIManagement km = new KPIManagement();
		NewAccount na = new NewAccount();
		
		// Data files and Sheets
		int tccount = XLUtils.getRowCount(keywordfile, tcsheet);
		int tscount = XLUtils.getRowCount(keywordfile, tssheet);
		String tcid, tcexeflag, tstcid, keyword, stepres, tcres;
		
		boolean res = false;
		
		// Test data fields
		String loginid,password;
		String fname, email, uname, designation, role, frole, dept;
		String kpiname, metric_type, metric_category, is_Higher_Better, goal, metric_criteria, baseline, department;
		String adminuname,lname, cname, adminrole, adminemail, mobNo, adminpassword, industry;
		
		for(int i=1; i<=tccount; i++)
		{
			tcid = XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
			tcexeflag = XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				for(int j=1; j<=tscount; j++)
				{
					tstcid = XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getStringCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "login":
							loginid = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							password = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							
							lp.login(loginid, password);
							res = lp.isLoginWorking();							
							break;
						case "logout":							
							res = lp.logout();
							break;
						case "createnewuser":
							fname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							email = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							uname = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
							designation = XLUtils.getStringCellData(keywordfile, tssheet, j, 8);
							role = XLUtils.getStringCellData(keywordfile, tssheet, j, 9);
							frole = XLUtils.getStringCellData(keywordfile, tssheet, j, 10);
							dept = XLUtils.getStringCellData(keywordfile, tssheet, j, 11);
							
							um.createNewUser(fname, email, uname, designation, role, frole, dept);
							res = um.isUsercreatedSuccessfully(fname);
							break;
						case "createnewtopic":
							kpiname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							metric_type = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							metric_category = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
							is_Higher_Better = XLUtils.getStringCellData(keywordfile, tssheet, j, 8);
							goal = XLUtils.getStringCellData(keywordfile, tssheet, j, 9);
							metric_criteria = XLUtils.getStringCellData(keywordfile, tssheet, j, 10);
							baseline = XLUtils.getStringCellData(keywordfile, tssheet, j, 11);
							department = XLUtils.getStringCellData(keywordfile, tssheet, j, 12);
							
							km.createKPI(kpiname, metric_type, metric_category, is_Higher_Better, goal, metric_criteria,baseline, department);
							res = km.isCreateNewTopicWorking(kpiname);
							break;
						case "createnewaccount":
							adminuname = XLUtils.getStringCellData(keywordfile, tcsheet, i, 5);
							lname = XLUtils.getStringCellData(keywordfile, tcsheet, i, 6);
							cname = XLUtils.getStringCellData(keywordfile, tcsheet, i, 7);
							adminrole = XLUtils.getStringCellData(keywordfile, tcsheet, i, 8);
							adminemail = XLUtils.getStringCellData(keywordfile, tcsheet, i, 9);
							mobNo = XLUtils.getStringCellData(keywordfile, tcsheet, i, 10);
							adminpassword = XLUtils.getStringCellData(keywordfile, tcsheet, i, 11);
							industry = XLUtils.getStringCellData(keywordfile, tcsheet, i, 12);
							na.createNewAccount(adminuname, lname, cname, adminrole, adminemail, mobNo, adminpassword, industry);
							res = na.iSCreateAcWorking();
							break;
						}
						// Code to update Test Step results
						if(res)
						{
							stepres = "Pass";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
							XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else
						{
							stepres = "Fail";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
							XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						// Code to update Test Case results
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(!tcres.equalsIgnoreCase("fail"))
						{
							XLUtils.setCellData(keywordfile, tcsheet, i, 3, stepres);
						}
						//Code to fill Test Case result colors
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(tcres.equalsIgnoreCase("pass"))
						{
							XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}						
						
					}
				}
			}else
			{
				XLUtils.setCellData(keywordfile, tcsheet, i, 3,"Blocked");
				XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
		}
	}
}
