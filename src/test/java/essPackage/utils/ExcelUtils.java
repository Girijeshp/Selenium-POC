package essPackage.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
public XSSFWorkbook workbook;
    XSSFSheet sheet;
    public ExcelUtils() throws IOException {
        // 1. Get the current project directory using System.getProperty("user.dir")
        // 2. Append the relative path to the Excel file to the project directory.
        // 3. Create a FileInputStream object to read the Excel file.
        // 4. Create a XSSFWorkbook object to work with the Excel file.

        String file = System.getProperty("user.dir") + "/src/test/java/resources/EssData.xlsx";
        FileInputStream filePath = new FileInputStream(file);
        workbook = new XSSFWorkbook(filePath);

    }
    // create a method to get the data from the excel sheet
    public String cellData(int row, int col) {
        // 1. Get the sheet named "sheet1" from the workbook.
        // 2. Get the row at the specified index (row) from the sheet.
        // 3. Get the cell at the specified index (col) from the row.
        // 4. Convert the cell value to a string and return it.

        sheet = workbook.getSheet("sheet1");
        XSSFRow rowNum = sheet.getRow(row);
        XSSFCell cell = rowNum.getCell(col);
        return cell.toString();

    }
    // create a method to get the row count
    public int rowCount() {
        // 1. Get the sheet named "sheet1" from the workbook.
        // 2. Get the last row number from the sheet.
        // 3. Add 1 to the last row number to get the total row count
        // 4. Return the total row count
        return workbook.getSheet("sheet1").getLastRowNum()+1;

    }

}
