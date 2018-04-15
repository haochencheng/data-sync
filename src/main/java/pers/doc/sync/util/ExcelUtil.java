package pers.doc.sync.util;

import com.google.common.base.Strings;
import com.mysql.cj.core.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtil {

    //读取excel
    public static Workbook readExcel(InputStream is,String filePath){
        if (is==null){
            return null;
        }
        if (Strings.isNullOrEmpty(filePath)){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        Workbook workbook=null;
        try {
            if(".xls".equals(extString)){
                 workbook = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                 workbook = new XSSFWorkbook(is);
            }else{
                 workbook = null;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    private String getCellStringVal(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                return cell.getStringCellValue();
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return "";
        }
    }



}
