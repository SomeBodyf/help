package com.somebody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somebody.serviece.auth.Authenticaion;

import com.somebody.serviece.equimpment.Equipment;

import com.somebody.serviece.lesson.Lesson;

import com.somebody.serviece.member.Member;

import com.somebody.serviece.pay.Pay;

import com.somebody.serviece.staff.Staff;

import beans.Equipments;
import beans.Members;
import beans.Pays;

@Controller 
public class ControllerYoung {
	@Autowired
	Authenticaion auth;
	@Autowired
	Equipment eq;
	@Autowired
	Pay pa;

	@RequestMapping(value = "/goGoodsPage", method = RequestMethod.POST)
	public void goGoodsPage(Model model, @ModelAttribute Equipments eq) {
		this.eq.backController("G01",eq);
	}
	
	@RequestMapping(value = "/payMg", method = RequestMethod.POST)
	public void payMg(Model model, @ModelAttribute Pays pa) {
		this.pa.backController("P01", pa);
	}
	
	@RequestMapping(value = "/psJoin", method = RequestMethod.POST)
	public void psJoin(Model model, @RequestBody Members[] me) {
		this.auth.backController2("P05",model.addAttribute("mebean",me[0]));
	}
	
	
	
	
	
}
