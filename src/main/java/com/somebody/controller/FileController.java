package com.somebody.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import beans.Inbodys;

/**
 * Handles requests for the application home page.
 * 
 * @component 어노테이션 사용시 메모리에 올려 사용가능 디스패처에서web.xml 자동으로 일로와짐, 종류 @controller,
 *            component, service, resource
 */
@Controller // package 찾음
//@RequestMapping(value ="/file",produces = "application/json;charset=UTF-8")
public class FileController {
	File tosaveFile;
	File savePath;

	@RequestMapping(value = "/getFilePage", method = RequestMethod.GET)
	public String home() {
		return "upload";
	}

	@RequestMapping(value = "/MultiPart", method = RequestMethod.GET)
	public String uploadFile(@RequestParam("file") MultipartFile[] f, @ModelAttribute Files data) {
		System.out.println(data.toString() + "새");
		for (MultipartFile e : f) {
			this.tosaveFile = new File(e.getOriginalFilename());

			try {
				e.transferTo(tosaveFile);
			} catch (IllegalStateException | IOException e1) {
				e1.printStackTrace();
			}
		}
		return "upload";
	}

	@RequestMapping(value = "/MultiPart2", method = RequestMethod.POST)
	@ResponseBody // rest방식아닐때 사용
	public void uploadOnAjax(@RequestParam("file") MultipartFile[] f, @ModelAttribute Inbodys in) {

		for (MultipartFile e : f) {
			System.out.println(e.getOriginalFilename() + "gg");
			this.savePath = new File("C:\\REST\\workspace\\help\\src\\main\\webapp\\resources\\excel",
					e.getOriginalFilename());
			try {

				e.transferTo(savePath);
				readFilter(e.getOriginalFilename());
			} catch (IllegalStateException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	
	public ArrayList<ArrayList<String>> readFilter(String fileName) throws IOException {
		
		FileInputStream fis = new FileInputStream(this.savePath.getPath());

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;		
		ArrayList<ArrayList<String>> filters = new ArrayList<ArrayList<String>>();		
		
		int sheetCn = workbook.getNumberOfSheets();	// 시트 수
		for(int sheetnum=0; sheetnum<sheetCn; sheetnum++) {	// 시트 수만큼 반복
			
			int sheetnum2=sheetnum+1;
			System.out.println("sheet = " + sheetnum2);
			
			XSSFSheet sheet = workbook.getSheetAt(sheetnum);	// 읽어올 시트 선택
			int rows = sheet.getPhysicalNumberOfRows();    // 행의 수
			XSSFRow row = null;
			
			for (rowindex = 1; rowindex < rows; rowindex++) {	// 행의 수만큼 반복

				row = sheet.getRow(rowindex);	// rowindex 에 해당하는 행을 읽는다
				ArrayList<String> filter = new ArrayList<String>();	// 한 행을 읽어서 저장할 변수 선언

				if (row != null) {
					int cells = 13;	// 셀의 수
					cells = row.getPhysicalNumberOfCells();    // 열의 수
					for (columnindex = 0; columnindex <= cells; columnindex++) {	// 열의 수만큼 반복
						XSSFCell cell_filter = row.getCell(columnindex);	// 셀값을 읽는다
						String value = "";
								// 셀이 빈값일경우를 위한 널체크
						if (cell_filter == null) {
							continue;
						} else {
									// 타입별로 내용 읽기
							switch (cell_filter.getCellType()) {
							case XSSFCell.CELL_TYPE_FORMULA:
								value = cell_filter.getCellFormula();
								break;
							case XSSFCell.CELL_TYPE_NUMERIC:
								value = cell_filter.getNumericCellValue() + "";
								break;
							case XSSFCell.CELL_TYPE_STRING:
								value = cell_filter.getStringCellValue() + "";
								break;
							case XSSFCell.CELL_TYPE_BLANK:
								value = cell_filter.getBooleanCellValue() + "";
								break;
							case XSSFCell.CELL_TYPE_ERROR:
								value = cell_filter.getErrorCellValue() + "";
								break;
							}
						}
						filter.add(value);	//읽은 셀들을 filter에 추가 (행)
					}
				}
				filters.add(filter); //filter(행)을 filters(열)에 추가
			}
		}
		fis.close();	//파일 읽기 종료
	
		System.out.println(filters.get(0));

		
		
		return filters;	//리스트 반환
	}
}

