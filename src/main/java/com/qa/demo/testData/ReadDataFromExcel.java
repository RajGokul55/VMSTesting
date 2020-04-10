package com.qa.demo.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.qa.demo.base.TestBase;

public class ReadDataFromExcel extends TestBase{

	public static Workbook book;
	public static FileInputStream ip;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static POIFSFileSystem fs;
	public static String password;

	public static Object[][] getdataFromExcel() {

		File file = new File(userDirectory+"\\src\\main\\java\\com\\qa\\demo\\testData\\newtours.xls");
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
		sheet = book.getSheet("Sheet1");
		Object object[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				object[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return object;
	}

	public static String getCredentials(int a) throws IOException {

		Biff8EncryptionKey.setCurrentUserPassword("Sinhgad@55");
		fs = new POIFSFileSystem( new File("\\\\apollo\\temp\\app\\AutomationFrameworkV0.1\\src\\main\\java\\com\\qa\\demo\\testData\\LoginDetails.xls"));
		book = new HSSFWorkbook(fs.getRoot(), true);
		Biff8EncryptionKey.setCurrentUserPassword(null);

		sheet = book.getSheet("LoginDetails");
		row = sheet.getRow(a);
		cell = row.getCell(3);
		password = cell.getStringCellValue();

		byte[] decodedString = Base64.decodeBase64(password);
		return (new String(decodedString));
	}

}
