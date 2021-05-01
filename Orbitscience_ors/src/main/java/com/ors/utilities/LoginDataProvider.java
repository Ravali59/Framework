package com.ors.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginDataProvider {
	XSSFWorkbook wb;
	public LoginDataProvider()
	{
		File src = new File ("./TestData/Data.xlsx");
		try {
		FileInputStream fis = new FileInputStream(src);
		 
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("unbale to read excel data"+e.getMessage());
		}
	}
	public String getStringData(int sheetindex,int row ,int cloloumn)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cloloumn).getStringCellValue();
	}
	public String getStringData(String sheetname,int row ,int cloloumn)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cloloumn).getStringCellValue();
	}
	public double getNumericData(String sheetname,int row ,int cloloumn) {
		
		return wb.getSheet(sheetname).getRow(row).getCell(cloloumn).getNumericCellValue();
		
	}

}
