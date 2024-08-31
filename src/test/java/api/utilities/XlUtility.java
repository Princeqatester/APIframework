package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtility {

    private String path;

    public XlUtility(String path) {
        this.path = path;
    }

    // Method to get the row count in a sheet
    public int getRowCount(String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
            }
            return sheet.getPhysicalNumberOfRows();
        }
    }

    // Method to get the number of cells in a specific row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
            }
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                return 0; // Return 0 if the row does not exist
            }
            return row.getLastCellNum();
        }
    }

    // Method to get the data from a specific cell
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
            }
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                return ""; // Return empty string if the row does not exist
            }
            XSSFCell cell = row.getCell(colNum);
            if (cell == null) {
                return ""; // Return empty string if the cell does not exist
            }
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }
}

/*package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtility 
{
public FileInputStream fi;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
String path;
public XlUtility(String path)
{
	this.path=path;
}
public int getrowcount(String sheetname) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	int rowcount=sheet.getPhysicalNumberOfRows();
	workbook.close();
	fi.close();
	return rowcount;
}
public int getcellcount(String sheetname,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	  int cellcount = 0;
      if (row != null) {
          cellcount = row.getLastCellNum();
      }
	//int cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
	return cellcount;
}
public String getcelldata(String sheetname,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	 String data = "";
     if (row != null) {
         cell = row.getCell(colnum);

         // Check if the cell is null
         if (cell != null) {
             DataFormatter formatter = new DataFormatter();
             try {
                 data = formatter.formatCellValue(cell);
             } catch (Exception e) {
                 data = "";
             }
	/*DataFormatter formatter=new DataFormatter();
	String data;
	try 
	{
		data=formatter.formatCellValue(cell);
	}
	catch(Exception e)
	{
		data="";
	}
	
}

}
     workbook.close();
 	fi.close();
	return data;
}
}*/

