package pers.doc.sync.controller;

import com.github.crab2died.ExcelUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.doc.sync.common.ReturnResult;
import pers.doc.sync.model.HalfYearDataStatistical;
import pers.doc.sync.model.SchedulingDataSource;
import pers.doc.sync.repository.HalfYearDataStatisticalRepository;
import pers.doc.sync.repository.SchedulingDataSourceRepository;
import pers.doc.sync.util.ExcelUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SyncExcel2DataController {

    private Logger logger = LoggerFactory.getLogger(SyncExcel2DataController.class);

    @Resource
    HalfYearDataStatisticalRepository halfYearDataStatisticalRepository;

    @Resource
    SchedulingDataSourceRepository schedulingDataSourceRepository;


    @RequestMapping("/sync/excel1")
    @ResponseBody
    public ReturnResult SyncExcel2Data1(@RequestParam("file") MultipartFile excelFile) throws IOException {
        logger.info(excelFile.getOriginalFilename());
        Workbook workbook = ExcelUtil.readExcel(excelFile.getInputStream(), excelFile.getOriginalFilename());
        Sheet sheet = workbook.getSheet("半年度");
        Row row = sheet.getRow(1);
        HalfYearDataStatistical halfYearDataStatistical = new HalfYearDataStatistical();
        CellType cellType = row.getCell(0).getCellTypeEnum();
        logger.info(cellType.name());
        String statisticalDate=row.getCell(0).getStringCellValue();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(statisticalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            halfYearDataStatistical.setStatisticalDate(date);
        }
        String area = row.getCell(1).getStringCellValue();
        if (area != null) {
            halfYearDataStatistical.setArea(area);
        }
        Double totalAmount = row.getCell(2).getNumericCellValue();
        if (totalAmount!=0) {
            halfYearDataStatistical.setTotalAmount(totalAmount.intValue());
        }
        halfYearDataStatisticalRepository.save(halfYearDataStatistical);
        return ReturnResult.ok();
    }

    @RequestMapping("/sync/excel")
    @ResponseBody
    public ReturnResult SyncExcel2Data(@RequestParam("file") MultipartFile excelFile) throws IOException {
        logger.info(excelFile.getOriginalFilename());
        try {
            List<SchedulingDataSource> schedulingDataSourceList=ExcelUtils.getInstance().readExcel2Objects(excelFile.getInputStream(), SchedulingDataSource.class,0,10,0);
            logger.info(schedulingDataSourceList.toString());
            schedulingDataSourceList.forEach((schedulingDataSource) ->
                schedulingDataSourceRepository.save(schedulingDataSource)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toIndex() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
