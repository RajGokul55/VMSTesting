package com.qa.demo.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteDataToExcel {

	public static Workbook book;
	public static FileInputStream ip;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static void writeOutputToExcel() {

		File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\NewtoursAutomationFramework\\src\\main\\java\\com\\qa\\newtours\\data\\newtours.xls");
		try {
			ip = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = new HSSFWorkbook(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("Output");
		row = sheet.createRow(1);
		cell = row.createCell(1);
		cell.setCellValue("Pravin");
		
	}
}
