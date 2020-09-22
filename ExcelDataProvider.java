package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ExcelDataProvider {
	
	public String path          = null;
	public FileInputStream fis  = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook wb      = null;
	public XSSFSheet sheet      = null;
	public XSSFCell cell        = null;
	public XSSFRow row          = null;
	

	public int getRowCount(String path,String Sheetname) {
		
		try
		{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(Sheetname);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("Exception at getRowCount in ExcelDataProvider");
		}
		
		int rc = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rc;
	}
	
	public int getColCount(String path,String Sheetname,int rownum) {
		try
		{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(Sheetname);
		}
		catch(Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("Exception at getCellCount in ExcelDataProvider");
		}
		
		int cc = sheet.getRow(rownum).getLastCellNum()-sheet.getRow(rownum).getFirstCellNum();
		return cc;
	}

    public void setCellData(String path,String Sheetname,int rownum,int cellnum,String val) {
    	try
		{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(Sheetname);
		row =   sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(val);
		fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("Exception at setCelldata in ExcelDataProvider");
		}
		
	}
    
    public String getCellData(String path,String Sheetname,int rownum,int cellnum)
    {
    	try
		{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(Sheetname);
		row =   sheet.getRow(rownum);
		cell = sheet.getRow(rownum).getCell(cellnum);
		cell.setCellType(CellType.STRING);
		}
		catch(Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("Exception at setCelldata in ExcelDataProvider");
		}
    	String cellData = cell.getStringCellValue();
		return cellData;
    	
    }
}
