package com.example.demo.utils.excel;

import com.example.demo.utils.CommonUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * 文件工具类
 *
 * @param
 * @author
 */
public class ExcelUtil {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	private final static String D = ".";
	private final static String XLS = ".xls";
	private final static String XLSX = ".xlsx";

	public static String getStringCellValue(Cell cell, String def)
	{
		return cell != null ? cell.getStringCellValue() : def;
	}
	public static Double getDoubleCellValue(Cell cell, Double def)
	{
		return cell != null ? cell.getNumericCellValue() : def;
	}
	public static Date getDateCellValue(Cell cell, Date def)
	{
		return cell != null ? cell.getDateCellValue() : def;
	}
	/**
	 * 读取Excel文件
	 * @param multExcelFile 文件路径
	 */
	public static Workbook readExcel(MultipartFile multExcelFile){
		if(multExcelFile.isEmpty()){
			return null;
		}
		String fileName = multExcelFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.indexOf(D));
		Workbook wb = null;
		InputStream inputS = null;
		File excelFile = null;
		try {
			// 防止生成的临时文件重复
	        excelFile = File.createTempFile(UUID.randomUUID().toString(), fileSuffix);
	        multExcelFile.transferTo(excelFile);
			inputS = new FileInputStream(excelFile);
			if(fileSuffix.equals(XLS)){
				wb = new HSSFWorkbook(inputS);
			}else if(fileSuffix.equals(XLSX)){
				wb = new XSSFWorkbook(inputS);
			}else{
				wb = null;
			}
			inputS.close();
		} catch (FileNotFoundException e) {
			logger.error("读取文件异常",e);
		} catch (IOException e) {
			logger.error("读取文件异常",e);
		}finally {
			try {
				if(inputS != null){
						inputS.close();
					} 
			}catch (IOException e) {
				logger.error("读取文件异常",e);
			}
			if (CommonUtils.isNotNull(excelFile)){
				FileUtils.deleteQuietly(excelFile);
			}
		}
		return wb;
	}
	
	/**
	 * 单元格格式转换 poi3.17
	 * @param cell 单元格
	 * @return
	 */
	public static Object getCellFormatValue(Cell cell){
		Object cellVal = null;
		if(cell != null){
			switch(cell.getCellType()){
				case Cell.CELL_TYPE_STRING:
					cellVal = cell.getRichStringCellValue().getString();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						Date date = cell.getDateCellValue();
						cellVal = DateFormatUtils.format(date, "yyyy-MM-dd");
					}else{
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cellVal = cell.getRichStringCellValue().getString();
					}
					break;
				case Cell.CELL_TYPE_FORMULA:
					if(DateUtil.isCellDateFormatted(cell)){
						cellVal = cell.getDateCellValue();
					}else{
						cellVal = String.valueOf(cell.getNumericCellValue());
					}
					break;
				default:
					cellVal = "";
				
			}
		}else{
			cellVal = "";
		}
		return cellVal;
	}
	
}
