package com.somebody.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 * 
 * @component 어노테이션 사용시 메모리에 올려 사용가능 디스패처에서web.xml 자동으로 일로와짐, 종류 @controller,
 *            component, service, resource
 */
@Controller // package 찾음
//@RequestMapping(value ="/file",produces = "application/json;charset=UTF-8")
public class FileController {


	@RequestMapping(value = "/getFilePage", method = RequestMethod.GET)
	public String home() {
		return "upload";
	}
	@RequestMapping(value = "/MultiPart", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile[] f,@ModelAttribute Files data) {
		System.out.println(data.toString()+"새");
		for(MultipartFile e: f) {
			File tosaveFile = new File(e.getOriginalFilename());
			System.out.println(tosaveFile.getName()+"네");
			try {
				e.transferTo(tosaveFile);
			} catch (IllegalStateException | IOException e1) {
				e1.printStackTrace();
			}
		}
		return "upload";
		
	}
	@RequestMapping(value = "/MultiPart2", method = RequestMethod.POST)
	@ResponseBody //rest방식아닐때 사용
	public String uploadOnAjax(@RequestParam("file") MultipartFile[] f,@ModelAttribute Files data) {
	
	
		for(MultipartFile e: f) {
			File tosaveFile = new File(e.getOriginalFilename());
			try {
				e.transferTo(tosaveFile);
			} catch (IllegalStateException | IOException e1) {
				e1.printStackTrace();
			}
		}
		return "upload";
		
	}
}


