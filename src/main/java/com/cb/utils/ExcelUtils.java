package com.cb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cb.constants.FrameworkConstants;
import com.cb.exceptions.InvalidFilePathForExcelException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {

		Map<String, String> map = null;
		List<Map<String, String>> list = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelfilepath());) {

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= rowCount; i++) {
				map = new HashMap<>();
				for (int j = 0; j < colCount; j++) {
					DataFormatter df = new DataFormatter();
					String key = df.formatCellValue(sheet.getRow(0).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i).getCell(j));
					map.put(key, value);

				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new InvalidFilePathForExcelException("Excel File path not found");
		} catch (IOException e) {
			throw new InvalidFilePathForExcelException("Excel File path not found");
		}
		return list;

	}

}
