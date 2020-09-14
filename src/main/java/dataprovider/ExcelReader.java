package dataprovider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelReader {

    static String sheetdirectory = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData";

    public static HashMap<String, String> storeTestData = new HashMap<>();

    public static List<HashMap<String, String>> GetTestData(String sheetname)
    {
        List<HashMap<String, String>> data = new ArrayList<>();
        try
        {
            FileInputStream testdatarepo = new FileInputStream(sheetdirectory+"\\DataRepository.xlsx");
            XSSFWorkbook excelworkbook = new XSSFWorkbook(testdatarepo);
            XSSFSheet excelsheet = excelworkbook.getSheet(sheetname);
            Row columnnamerow = excelsheet.getRow(0);
            for(int row = 1; row<excelsheet.getPhysicalNumberOfRows(); row++)
            {
                Row currentRow = excelsheet.getRow(row);
                HashMap<String, String> currentRowData = new HashMap<>();
                for(int cell = 0; cell<currentRow.getPhysicalNumberOfCells(); cell++)
                {
                    Cell currentCell = currentRow.getCell(cell);
                    currentRowData.put(columnnamerow.getCell(cell).getStringCellValue(), currentCell.getStringCellValue());


                }
                data.add(currentRowData);
            }
            excelworkbook.close();
            testdatarepo.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }

}
