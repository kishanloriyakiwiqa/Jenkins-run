package com.demoqa.qa.base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataClass {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static int totalRows;
	public static int totalColumns;
	public static DataFormatter format = new DataFormatter();

	public DataClass() {

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/com/demoqa/qa/testdata/DemoqaTestData.xlsx");
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("DataSet1");
			totalRows = sheet.getLastRowNum();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, String> userData() {
		Map<String, String> userInput = new HashMap<>();

		for (int i = 1; i <= totalRows; i++) {

			totalColumns = sheet.getRow(i).getLastCellNum();
			String key = null;

			for (int j = 0; j < totalColumns; j++) {

				String value = format.formatCellValue(sheet.getRow(i).getCell(j));

				if (j == 0) {
					key = value;
				} else {
					if (j >= 2) {
						key = key + (j - 1);
					}
				}

				userInput.put(key, value);

			}
		}

		return userInput;

	}
}
