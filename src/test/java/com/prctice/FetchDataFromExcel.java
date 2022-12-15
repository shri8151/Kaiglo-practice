package com.prctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	

	public static void main (String[] args) throws IOException
	{
		
		FetchDataFromExcel fd=new FetchDataFromExcel();
		String un = fd.getExcelData("CustomerDetails", "MyAccount", "e-mail");
		System.out.println(un);
		fd.writeToExcel("CustomerDetails", 1, 12,"pass");
	}

	public String getExcelData(String sheetName,String TestCaseName,String columnName) throws EncryptedDocumentException, IOException 
	{
		
	FileInputStream fisExl=new FileInputStream("./src/test/resources/TestData.xlsx");
   Workbook wb = WorkbookFactory.create(fisExl);
	String data = null;
	DataFormatter df=new DataFormatter();

	try
	{
		  Sheet sheet = wb.getSheet(sheetName);
		int rowLength = sheet.getLastRowNum();
		int cellLength=sheet.getRow(0).getLastCellNum();
		String expectedTestCaseName=TestCaseName;
		String expextedColumnName=columnName;
		
		for(int i=0;i<=rowLength;i++) 
		{
			String actualTestCaseName=sheet.getRow(i).getCell(0).toString();
			if(expectedTestCaseName.equals(actualTestCaseName)) 
			{
				for(int j=1;j<cellLength;j++)
				{
					String actualColumnName = sheet.getRow(i).getCell(j).toString();
					if(expextedColumnName.equals(actualColumnName))
					{
						data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;			
			}
		}
	}
	
catch(EncryptedDocumentException e) 
	{
	e.printStackTrace();
	}
finally
{
	wb.close();
	fisExl.close();
}
return data;
}
	
@SuppressWarnings("null")
public void writeToExcel(String sheetname,int row,int cell,String value) throws EncryptedDocumentException, IOException
{
	try {
		
	
	FileInputStream fisExl=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fisExl);
	
	wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(value);
	
	FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
	wb.write(fos);
	}
	finally 
	{
		
	
	Workbook wb = null;
	wb.close();
	FileInputStream fis = null;
	fis.close();
	}
}
}



