package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {
	@Test
	public void writeExcel() throws IOException {
		String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";

		FileInputStream fis = new FileInputStream(xlPath);
		//open workbook
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=wbook.getSheet("EmployeeDetails");
		
		//write same value
		
		sheet.getRow(0).createCell(4).setCellValue("Result");
		
		sheet.getRow(0).createCell(4).setCellValue("Pass");
		sheet.getRow(0).createCell(4).setCellValue("Fail");
		
		sheet.createRow(11).createCell(0).setCellValue("Meral");
		//write to the excel
		FileOutputStream fos=new FileOutputStream(xlPath);
		wbook.write(fos);
		
		fos.close();
		wbook.close();
		fis.close();
		
	}

}
