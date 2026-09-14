package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;
    private static FileInputStream fis;

    // Load Excel
    public static void loadExcel(String filePath, String sheetName)
            throws IOException {

        fis = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException(
                    "Sheet '" + sheetName +
                    "' not found in Excel file. Available sheets: "
                    + workbook.getNumberOfSheets());
        }

        System.out.println("Excel loaded successfully: " + filePath);
        System.out.println("Sheet loaded: " + sheetName);
    }

    // Get row count
    public static int getRowCount() {

        if (sheet == null) {
            throw new IllegalStateException(
                    "Excel sheet is not loaded. Call loadExcel() first.");
        }

        return sheet.getPhysicalNumberOfRows();
    }

    // Get cell data
    public static String getCellData(int rowNum, int colNum) {

        if (sheet == null) {
            throw new IllegalStateException(
                    "Excel sheet is not loaded.");
        }

        Row row = sheet.getRow(rowNum);

        if (row == null) {
            return "";
        }

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
                row.getCell(colNum));
    }

    // Close Excel
    public static void closeExcel() throws IOException {

        if (workbook != null) {
            workbook.close();
        }

        if (fis != null) {
            fis.close();
        }

        workbook = null;
        sheet = null;
        fis = null;
    }
}