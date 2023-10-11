package Utlis;

import java.io.File;

public class Utility {

	// 2 methode
	// 1-> to get the data from excel sheet
	// 2-> to capture the Screenshot
	
	public static String getDataFromExcelSheet(String filepath, String sheet,int row, int cell ) {

		// Excelsheet code 
		//String path = filepath ;
		String data = "" ;
		
//		FileInputStream file = new FileInputStream(filepath) ;
//		WorkbookFactory.creat(file).getSheet("TestDat").getRow(row).getCell(cell)
//				
//				try {
//					 data = .getStringCellValue() ;
//				}
//				 catch(InvalidStateExc. refe) {
//					 double value  = .getNumnericCellValue() ;
//					 // How to convert double to string in JAVA
//					 data = value->String ;
//				 }
//		 		catch (NullpointerExc. refe) 
//				 {
//				 	System.out.println("Cell is blank");
//				 }
		 // File colsed 
		return data ;
	}
	
	public static void captureScrenshot(String testID) {
		// Code 
		// File Name -> Test-TestID 04-10-2023 08 35 34.jpg
		File dest = new File("test-output\\FailedTestScreenshot\\Test - " + testID +DateTime);
		
	}
}
