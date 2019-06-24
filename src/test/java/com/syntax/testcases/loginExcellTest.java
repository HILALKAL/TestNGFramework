package com.syntax.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.LoginPage;
import com.syntax.utils.Constans;
import com.syntax.utils.ExcelUtility;

public class loginExcellTest {
	
	@Test(dataProvider="loginT")
	public void login(String url,String username,String password) {
		LoginPage login=new LoginPage();
		login.login(username, password);
	}
	
	@DataProvider(name="loginT")
	public void getData() {
		ExcelUtility excel=new ExcelUtility();
		excel.openExcel(Constans.LOGIN, "loginTest");
		int rows=excel.getRowNum();
		int cols=excel.getColNum(0);
		
		Object [][] data=new Object[rows-1][cols];//I dont want to get header
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				
				String value=excel.getCellData(i, j);
				data[i-1][j]=value;//it is to store 0 st row in to the data.
				
				
			}
		}
		
	System.out.println(data.length);
	}

}
