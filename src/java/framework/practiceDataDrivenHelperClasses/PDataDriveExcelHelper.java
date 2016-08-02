package practiceDataDrivenHelperClasses;

import java.io.FileInputStream;

import java.util.Iterator;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class PDataDriveExcelHelper {

	private String filePath;
	private FileInputStream fis;
	private Workbook workbook;
	
	public PDataDriveExcelHelper(String filepath){
		this.filePath = filepath;
		try {
			fis = new FileInputStream(filepath);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Get total number of row in excel sheet
	public int getRowCount(String sheetName ){
		try{
			return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		}catch(NullPointerException e){
			return 0;
		}
	}

	public int getCellCount( String sheetName, int rowNumber){
		try {
			return workbook.getSheet(sheetName).getRow(rowNumber).getPhysicalNumberOfCells();
		} catch (Exception e) {
			return 0;
		}
	}

	public String getCellData(String sheetName, int rowNum, int colNum){
		try {
			return workbook.getSheet(sheetName).getRow(rowNum -1).getCell(colNum-1).toString();
		} catch (NullPointerException e) {
			return "";
		}
	}

	public int getRowNumber(String sheetName, int colNum, String cellValue){
		Iterator<Row> itr = workbook.getSheet(sheetName).rowIterator();
		while(itr.hasNext()){
			try {
				Row row = itr.next();
				if(row.getCell(colNum -1).toString().equals(cellValue))
					return row.getRowNum()+1;
			} catch (NullPointerException e) {
				continue;
			}
		}
		return -1;
	}

	public int getColNumber(String sheetName, int rowNum, String cellValue){
		try {
			Row row = workbook.getSheet(sheetName).getRow(rowNum);
			Iterator<Cell> itr = row.cellIterator();
			while(itr.hasNext()){
				Cell cell = itr.next();
				if(cell.toString().equals(cellValue))
					return cell.getColumnIndex() +1;
			}
			return -1;
		} catch (NullPointerException e) {
			return -1;
		}
	}
}
