package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	/**
	 * method that will open specified xlFile and sheet
	 * @param xlFilePath
	 * @param sheetName
	 */
	public void openExcel(String xlFilePath,String sheetName) {

		try {
			 fis = new FileInputStream(xlFilePath);
			 workbook = new XSSFWorkbook(fis);
			 sheet=workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * method will return String value of specified cell
	 * @param rowIndex
	 * @param cellIndex
	 * @return String
	 */
	
	public String getCellData(int rowIndex,int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	/**
	 * method will return number of actual used rows
	 * @return int
	 */
	public int getRowNum() {
		return sheet.getPhysicalNumberOfRows();
	}
	/**
	 * method will return number of last columns
	 * @return int
	 */
	public int getColNum(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
}
