package Testcases;

import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) throws IOException {
		//Readingdatafromexcel.excelreader();
		Readingdatafromexcel xlsreader=new Readingdatafromexcel("TestData\\SampleExcel.xlsx");
		System.out.println(xlsreader.getCellData("Sheet1",1, 2));

	}

}
