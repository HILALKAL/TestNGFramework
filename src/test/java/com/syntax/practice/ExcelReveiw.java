package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReveiw {
	@Test
	public void readExcel() throws IOException {
		String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";

		FileInputStream fis = new FileInputStream(xlPath);
		//open workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//open specified sheet
		XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
		//access value of specific cell
		String value = sheet.getRow(6).getCell(0).toString();
		System.out.println(value);

		// get number of rows and cols
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows and cols " + rows + " " + cols);

		// get value from each cell 1 by 1
		for (int a = 1; a < rows; a++) {// ilk row head oldugu icin 1 den baslanmali
			for (int b = 0; b < cols; b++) {
				String cellvalue = sheet.getRow(a).getCell(b).toString();
				System.out.println(cellvalue);
			}
		}

		workbook.close();
		fis.close();

	}
}