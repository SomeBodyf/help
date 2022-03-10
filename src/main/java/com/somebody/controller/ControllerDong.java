package com.somebody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somebody.serviece.lesson.Lesson;
import com.somebody.serviece.staff.Staff;

import beans.Centers;
import beans.Lessons;

@Controller 
public class ControllerDong {
	@Autowired
	Staff sf;
	@Autowired
	Lesson ls;

	@RequestMapping(value = "/goSfPage", method = RequestMethod.POST)
	public void meLogin(Model model, @ModelAttribute Staff sf) {
		this.sf.backController("S01", sf);
	}
	@RequestMapping(value = "/goLessonPage", method = RequestMethod.POST)
	public void goLessonPage(Model model, @ModelAttribute Lessons ls) {
		this.ls.backController("L01", ls);
	}

	
}

