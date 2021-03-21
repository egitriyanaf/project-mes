package com.agit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
*
* @author ridwan m
*/
public class ReadExcel {
	
    /**
     *
     * @param inpFile
     * @param path
     * @return
     */
    public List<ArrayList<String>> baca(File inpFile, String path) {
		List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		Workbook wb = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inpFile);
			if (path.endsWith("xls")) {
				wb = new HSSFWorkbook(fis);
			} else if (path.endsWith("xlsx")) {
				wb = new XSSFWorkbook(fis);
			}
			Sheet ws = wb.getSheetAt(0);

			int rowNum = ws.getLastRowNum() + 2;
			int colNum = ws.getRow(0).getLastCellNum();
			ArrayList<String> dt = null;

			for (int i = 1; i < rowNum; i++) {
				Row row = ws.getRow(i);
				dt = new ArrayList<String>();
				for (int j = 0; j < colNum; j++) {
					Cell cell = row.getCell(j);
					String value = cellToString(cell);
					dt.add(j, value);

				}
				data.add(dt);
			}
		} catch (Exception e) {
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

    /**
     *
     * @param cell
     * @return
     */
    public static String cellToString(Cell cell) {
		Object temp = null;
		String result = null;
		if (cell != null) {
			int type;
			type = cell.getCellType();
			switch (type) {

			case 0:// numeric value in excel
				temp = cell.getNumericCellValue();
				result = temp.toString();
				break;
			case 1: // string value in excel
				temp = cell.getStringCellValue();
				result = temp.toString();
				break;
			case 2: // boolean value in excel
				temp = cell.getBooleanCellValue();
				result = temp.toString();
				break;
			}
		}
		return result;
	}
}
