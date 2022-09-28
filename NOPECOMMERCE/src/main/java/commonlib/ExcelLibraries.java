package commonlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibraries {
String Filepath="C:\\Users\\VEGI\\MavenProjectNew\\NOPECOMMERCE\\Data\\NopEcommerceData.xlsx";
	
	public String ReadData(String Sheet,int RowNum,int ColumnNum) throws EncryptedDocumentException, IOException
	{
		File file=new File(Filepath);
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(Sheet);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.getCell(ColumnNum);
		String Value = cell.getStringCellValue();
		return Value;
	}
	
	public int GetRowCount(String Sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(Sheet);
		int RowCount = sheet.getLastRowNum();
		return RowCount;

	}
	public void WriteData(String Sheet,int RowNum,int ColumnNum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(Sheet);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.getCell(ColumnNum);
		cell.setCellType(CellType.STRING);
		FileOutputStream fos=new FileOutputStream(Filepath);
		cell.setCellValue(value);
		wb.write(fos);
		wb.close();
	}


}
