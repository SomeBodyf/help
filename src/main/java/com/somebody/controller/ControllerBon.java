package com.somebody.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.somebody.serviece.member.Member;
import com.somebody.serviece.pay.Pay;
import com.somebody.serviece.staff.Staff;

import beans.Centers;
import beans.Members;


@Controller 
public class ControllerBon {
	@Autowired
	Authenticaion auth;
	@Autowired
	Equipment eq;
	@Autowired
	Lesson ls;
	@Autowired
	Member me;
	@Autowired
	Pay pa;
	@Autowired
	Staff sf ;

	private static final Logger logger = LoggerFactory.getLogger(ControllerBon.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/meLogin", method = RequestMethod.POST)
	public void meLogin(Model model, @ModelAttribute Centers ct) {
		System.out.println(ct.getCtCode());
		this.auth.backController("A03",ct);
	}

	@RequestMapping(value = "/ctLogin", method = RequestMethod.POST)
	public void ctLogin(Model model, @ModelAttribute Centers ct) {
		this.auth.backController("A03",ct);
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public void logOut(Model model, @ModelAttribute Centers ct) {
		this.auth.backController("A04",ct);
	}

	@RequestMapping(value = "/sendEmailForm", method = RequestMethod.GET)
	public void sendEmailForm(Model model, @ModelAttribute Centers ct) {
		this.auth.backController("A05",ct);
	}

	@RequestMapping(value = "/ctJoinForm", method = RequestMethod.GET)
	public void ctJoinForm(Model model, @ModelAttribute Centers ct) {
		this.auth.backController("J01",ct);
	}

	@RequestMapping(value = "/ctJoin", method = RequestMethod.POST)
	public void ctJoin(Model model, @ModelAttribute Centers ct) {
		this.auth.backController("J02",ct);
	}
	@RequestMapping(value = "/goMePage", method = RequestMethod.POST)
	public void goMePage(Model model, @ModelAttribute Members me) {
		this.me.backController("M01", me);
	}

	




}
