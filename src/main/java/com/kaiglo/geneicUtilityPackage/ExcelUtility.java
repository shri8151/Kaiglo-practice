package com.kaiglo.geneicUtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains methods of using excel data.
 * @author Srikanth
 *
 */
public class ExcelUtility {
FileInputStream	fisExl;
Workbook wb;
DataFormatter df;
	/**
 * This method is used to fetch data from the Excel file	
 * @param sheetName
 * @param TestCaseName
	 * @param columnName 
 * @param columnName
 * @return
	 * @throws IOException 
 */
	public String getDatafromExcel(String sheetName,String TestCaseName, String columnName ) throws IOException 
	{
		fisExl = new FileInputStream(IConstantPath.EXCEL_PATH);
	    wb = WorkbookFactory.create(fisExl);
	    String data=null;
	    DataFormatter df=new DataFormatter();
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
		  wb.close();
	      fisExl.close();
		  return data;
		 }
    
	
   /**
	 * This method is used for writing the data/value into the excel file.
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

   public void writeToExcel(String sheetname,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{	
		
		FileInputStream fisExl=new FileInputStream(IConstantPath.EXCEL_PATH);
		wb = WorkbookFactory.create(fisExl);
		
		wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantPath.EXCEL_PATH);
		wb.write(fos);
		
		wb.close();
		fisExl.close();
	}
  
   
   /**
    * This method is used to fetch the data from excel.
    * @param sheetName
    * @param rowNum
    * @param cellNum
    * @return
    * @throws EncryptedDocumentException
    * @throws IOException
    */
   public String getExcelData(String sheetName,int rowNum,int cellNum)  {
	  
	    
			try {
				fisExl = new FileInputStream(IConstantPath.EXCEL_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		     
		    try {
				wb = WorkbookFactory.create(fisExl);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    Sheet sheet = wb.getSheet(sheetName);
		    Row row = sheet.getRow(rowNum);
		    String data = row.getCell(cellNum).getStringCellValue();
		    try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    try {
				fisExl.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return data;
	    
	     }

   /*
    * THhis method is used to open the excel file
    * @throws FileNotFoundException
    * @throws EncryptedDocumentException
    */
   public void openExelFile()  {
		  
	    try {
			fisExl = new FileInputStream(IConstantPath.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	     
	    try {
			wb = WorkbookFactory.create(fisExl);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
   /*
    * THhis method is used to close the excel file
    * @throws FileNotFoundException
    * @throws EncryptedDocumentException
    */
   public void closeExelFile() {
	   try {
			wb.close();
		}
	   catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			fisExl.close();
		} 
	    catch (IOException e) {
			e.printStackTrace();
		}
   }
   /**
    * This method is used to fetch multiple data from excel and store in the String[][].
    * @param sheetName
    * @return
    */
   public String[][] getDataFromExcel(String sheetName) {
	   Sheet sheet = wb.getSheet(sheetName);
	   int lastRowNumber = sheet.getLastRowNum();
	   short lastCellNumber = sheet.getRow(0).getLastCellNum();//2
	   df=new DataFormatter();
	   String[][] arr = new String[lastRowNumber][lastCellNumber];
	   for(int i=0;i<lastRowNumber;i++) {
		   for(int j=0;j<lastCellNumber;j++) {
		    arr[i][j] =df.formatCellValue(sheet.getRow(i+1).getCell(j));
		   }
	   }
	   return arr;
	 }
   /**
    * This method is used to fetch the excel data based on sheet name and expected key.
    * @param sheetName
    * @param expectedKey
    * @return
    */
   public String getDataFromExcel(String sheetName,String expectedKey) {
	   Sheet sheet = wb.getSheet(sheetName);
	  short lastCellNumber=sheet.getRow(0).getLastCellNum();
	  String value="";
	  for(int i=0;i<lastCellNumber;i++) {
		  String actualKey = sheet.getRow(0).getCell(i).getStringCellValue();
		       if(actualKey.equals(expectedKey)) {
		    	   value=sheet.getRow(1).getCell(i).getStringCellValue();
		    	   break;
		       }
	    }
	  return value;
   }
}
 
   
   
