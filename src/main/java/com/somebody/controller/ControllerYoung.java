package com.somebody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.serviece.auth.Authenticaion;

import com.somebody.serviece.equimpment.Equipment;

import com.somebody.serviece.lesson.Lesson;

import com.somebody.serviece.pay.Pay;

import beans.Equipments;
import beans.Members;
import beans.Pays;

@Controller 
public class ControllerYoung {
	@Autowired
	Authenticaion auth;
	@Autowired
	Lesson ls;
	@Autowired
	Equipment eq;
	@Autowired
	Pay pa;

	@RequestMapping("/goGoodsPage")
	public ModelAndView goGoodsPage(Model model, @ModelAttribute Equipments eq) {
		return this.eq.backController1("G01",eq);
	}
	
	@RequestMapping(value = "/payMg", method = RequestMethod.POST)
	public void payMg(Model model, @ModelAttribute Pays pa) {
		this.pa.backController("P01", pa);
	}
	
	@RequestMapping(value = "/psJoin", method = RequestMethod.POST)
	public void psJoin(Model model, @ModelAttribute Members me) {
		this.auth.backController2("P05",me);
	}
	
	
	
	
	
}
