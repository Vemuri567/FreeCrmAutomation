package Testcases;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Hashmap_Excel {
 /*public static void main(String[] args) throws IOException 
 {

		FileInputStream fs=new FileInputStream("TestData\\SampleExcel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet ws=wb.getSheet("Sheet1");
		XSSFRow Header_row=ws.getRow(0);
		List<String> columnHeader=new ArrayList<String>();
		int headercolumncount=Header_row.getLastCellNum();
		int headerrowcount=ws.getLastRowNum();
		//System.out.println(headerrowcount);
		for(int i=0;i<=headercolumncount-1;i++)
		{
			XSSFCell cell=Header_row.getCell(i);
			
			columnHeader.add(cell.getStringCellValue());
			//System.out.println(columnHeader.get(i));
		}
		Map<String, Map<String, String>> completeSheetData = new LinkedHashMap<String, Map<String, String>>();

		
		for(int i=1;i<=headerrowcount;i++)
		{
			Map<String,String> Rowsdata=new LinkedHashMap<String,String>();
			XSSFRow currentrow=ws.getRow(i);
			for(int j=0;j<=headercolumncount-1;j++)
			{
				String cellValue = null;
				XSSFCell cell=currentrow.getCell(j);
				if (cell == null){
					cellValue= "";
					Rowsdata.put(columnHeader.get(j), cellValue);
				}
					
				else{
			        switch (cell.getCellType()) 
			        {
			            case NUMERIC:
			                cellValue = String.valueOf((long)cell.getNumericCellValue());
			                if (HSSFDateUtil.isCellDateFormatted(cell)) {
								// format in form of M/D/YY
								double d = cell.getNumericCellValue();

								Calendar cal = Calendar.getInstance();
								
								cal.setTime(HSSFDateUtil.getJavaDate(d));
								cellValue = (String.valueOf(cal.get(Calendar.YEAR)));
								//cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
								cellValue = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellValue;
								// System.out.println(cellText);

							}
			                
			                break;
			            case STRING:
			                cellValue = cell.getStringCellValue();
			                
			                break;
			            case BOOLEAN:
			                cellValue = String.valueOf(cell.getBooleanCellValue());
			                
			                break;
			            case FORMULA:
			                cellValue= cell.getCellFormula();
			                if (HSSFDateUtil.isCellDateFormatted(cell)) {
								// format in form of M/D/YY
								double d = cell.getNumericCellValue();

								Calendar cal = Calendar.getInstance();
								
								cal.setTime(HSSFDateUtil.getJavaDate(d));
								cellValue = (String.valueOf(cal.get(Calendar.YEAR)));
								//cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
								cellValue = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellValue;
								// System.out.println(cellText);

							}
			                
			            case BLANK:
			                cellValue="BLANK";
			               
			            default:
			                cellValue ="DEFAULT";
			               
			        }
			        Rowsdata.put(columnHeader.get(j), cellValue);
				}

		        //System.out.println(cellValue);
		        
					
			}
			completeSheetData.put(String.valueOf(i), Rowsdata);
			
				
		}
		//System.out.println(completeSheetData);
		fs.close();
		for(int i=1;i<=(completeSheetData.size());i++)
		{
			
				System.out.println(completeSheetData.get(String.valueOf(i)).get("UserName"));
				//System.out.println(completeSheetData.get(String.valueOf(i)).get("Password"));
			
		}
		
  }*/
	// Java program to write data in excel sheet using java code

	
	//public class WriteDataToExcel {

		// any exceptions need to be caught
		public static void main(String[] args) throws Exception
		{
			// workbook object
			XSSFWorkbook workbook = new XSSFWorkbook();

			// spreadsheet object
			XSSFSheet spreadsheet
				= workbook.createSheet(" Student Data ");

			// creating a row object
			XSSFRow row;

			// This data needs to be written (Object[])
			Map<String, Object[]> studentData
				= new TreeMap<String, Object[]>();

			studentData.put(
				"1",
				new Object[] { "Roll No", "NAME", "Year" });

			studentData.put("2", new Object[] { "128", "Aditya",
												"2nd year" });

			studentData.put(
				"3",
				new Object[] { "129", "Narayana", "2nd year" });

			studentData.put("4", new Object[] { "130", "Mohan",
												"2nd year" });

			studentData.put("5", new Object[] { "131", "Radha",
												"2nd year" });

			studentData.put("6", new Object[] { "132", "Gopal",
												"2nd year" });

			Set<String> keyid = studentData.keySet();

			int rowid = 0;

			// writing the data into the sheets...

			for (String key : keyid) {

				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = studentData.get(key);
				int cellid = 0;

				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String)obj);
				}
			}

			// .xlsx is the format for Excel Sheets...
			// writing the workbook into the file...
			FileOutputStream out = new FileOutputStream(
				new File("C:/Users/NAVEEN/Documents/GFGsheet.xlsx"));

			workbook.write(out);
			out.close();
		}
	}

		


