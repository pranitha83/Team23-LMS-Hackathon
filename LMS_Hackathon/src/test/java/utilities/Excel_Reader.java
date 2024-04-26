package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	

	
	
	
	public List<Map<String, String>> getData(String excelpath, String sheetname) throws IOException
	{
		List<Map<String, String>> sheetData = null;
		
			FileInputStream fs = new FileInputStream(excelpath);
			 XSSFWorkbook workbook = new XSSFWorkbook(fs);
				XSSFSheet sheet = workbook.getSheet(sheetname);
				sheetData = ReadSheet(sheet);
			
		
				workbook.close();
		        fs.close();
		
		return sheetData;
		
	}
	
	private List<Map<String, String>> ReadSheet(Sheet sheet) 
	{
		Row row;
		Cell cell;

		int rowCount = sheet.getLastRowNum();

		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

		for (int currentRow = 1; currentRow <= rowCount; currentRow++) 
		{
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();

			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) 
			{
				cell = row.getCell(currentColumn);
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}
			excelRows.add(columnMapdata);
		}
		
		 
		return excelRows;
	}
}
