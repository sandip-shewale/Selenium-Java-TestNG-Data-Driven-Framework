package commonMethods;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadWriteXLSXFile {

    public static Map<Object, Object> readXLSXFileData(String filePath, String sheetName) {

        Map<Object, Object> data = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell user = row.getCell(0);
                Cell pass = row.getCell(1);
                Object userName = user.getStringCellValue();
                Object passWord = pass.getStringCellValue();
                data.put(userName, passWord);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;

    }

}
