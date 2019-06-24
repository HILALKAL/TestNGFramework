package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constans;
import com.syntax.utils.ExcelUtility;

import bsh.org.objectweb.asm.Constants;

public class ExcelFunctionsTest {

	@Test
	
	public void excelTest() {
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constans.XL_FILEPATH, "EmployeeDetails");
		
		//retrieve all values from excel and store 2D Object array
		
		int row =obj.getRowNum();
		int cell=obj.getColNum(0);
		
		Object [][] data =new Object [row][cell];
		
		
		for(int i=1;i<row;i++) {
			for(int y=0;y<cell;y++) {
				String value=obj.getCellData(i, y);
				data[i][y]=value;
			}
		}
		System.out.println(data.length);
	
	}
	
}
