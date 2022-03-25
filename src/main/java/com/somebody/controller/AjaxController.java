package com.somebody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.db.MapperUone;
import com.somebody.serviece.auth.Authenticaion;
import com.somebody.serviece.equimpment.Equipment;
import com.somebody.serviece.lesson.Lesson;
import com.somebody.serviece.member.Member;
import com.somebody.serviece.pay.Pay;
import com.somebody.serviece.staff.Staff;


import beans.Centers;
import beans.Equipments;
import beans.Lessons;
import beans.Members;
import beans.Pays;
import beans.Staffs;


@RestController
@RequestMapping(value ="/ajax",produces = "application/json;charset=UTF-8")
public class AjaxController {
	
	@Autowired
	Authenticaion auth;
	@Autowired
	Member me;
	@Autowired
	Staff sfs;
	@Autowired
	Lesson lss;
	@Autowired
	Equipment eq;
	@Autowired
	Pay pa;
	@Autowired
	private MapperUone mu;

	public AjaxController(){}
	
	//Bon

	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/meMg", method = RequestMethod.POST)
	public List<Members> meMg(Model model, @RequestBody Members[] me) {
		
		this.me.backController("M02",model,me[0]);
		return (List<Members>)model.getAttribute("meList");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchMeMg", method = RequestMethod.POST)
	public List<Members> searchMeMg(Model model, @RequestBody Members[] me) {
		this.me.backController("M03",model.addAttribute("sendmelist",me[0]));
		return (List<Members>)model.getAttribute("getmelist");
	}

	@RequestMapping(value = "/meDetail", method = RequestMethod.POST)
	public void meDetail(Model model, @RequestBody Members me) {
		this.me.backController("M04",model);
	}

	
	@RequestMapping(value = "/modMe", method = RequestMethod.POST)
	public void modMe(Model model, @RequestBody Members me) {
		this.me.backController("M07", model);

	}

	//Dong

	@SuppressWarnings("unchecked")
	@RequestMapping("/sfMg")
	public List<Staffs> sfMg(Model model, @RequestBody Staffs[] sf) {
		sfs.backController("S01",sf[0], model);
		return (List<Staffs>)model.getAttribute("sfList");


	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchSfMg")
	public List<Staffs> searchSfMg(Model model, @RequestBody Staffs[] sf) {

		this.sfs.backController("S02", sf[0], model.addAttribute("sf",sf[0]));
		return (List<Staffs>)model.getAttribute("sfList");
	}
	@RequestMapping(value = "/getMaxSf", method = RequestMethod.POST)
	public void getMaxSf(Model model, @RequestBody Staffs[] sf) {
		this.sfs.backController("S03", sf[0], model);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/insSf")
	public List<Staffs> insSf(Model model, @RequestBody Staffs[] sf) {

		this.sfs.backController("S04", sf[0], model);

		return (List<Staffs>)model.getAttribute("sfList");
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/modSf")
	public List<Staffs> modSf(Model model, @RequestBody Staffs[] sf) {

		this.sfs.backController("S07",sf[0], model);

		return (List<Staffs>)model.getAttribute("modSf");
	}
	@RequestMapping(value = "/getMeMg", method = RequestMethod.POST)
	public void getMeMg(Model model, @RequestBody Staffs[] sf) {
		this.sfs.backController("S09", sf[0], model);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/lessonMg")
	public List<Lessons> lessonMg(Model model, @RequestBody Lessons[] ls) {
		lss.backController("L01",ls[0], model.addAttribute("ls", ls[0]));
		return (List<Lessons>)model.getAttribute("lsList");

	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchLesson")
	public List<Lessons> searchLesson(Model model, @RequestBody Lessons[] ls) {
		this.lss.backController("L02",ls[0],model.addAttribute("ls", ls[0]));
		return (List<Lessons>)model.getAttribute("searchLesson");
	}
	/*@RequestMapping(value = "/getLsCaList", method = RequestMethod.POST)
	public void getLsCaList(Model model, @RequestBody Lessons[] ls) {
		this.lss.backController("L03",ls[0],model);
	}*/

	@RequestMapping(value = "/insLsPay", method = RequestMethod.POST)
	public List<Lessons> insLsPay(Model model, @RequestBody Lessons[] ls) {
		this.lss.backController("L04",ls[0],model);
		return (List<Lessons>)model.getAttribute("insLsPay");
	}
	@RequestMapping(value = "/getMaxLesson", method = RequestMethod.POST)
	public void getMaxLesson(Model model, @RequestBody Lessons[] ls) {
		this.lss.backController("L05",ls[0],model);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insLesson", method = RequestMethod.POST)
	public List<Lessons> insLesson(Model model, @RequestBody Lessons[] ls) {
		this.lss.backController("L06",ls[0],model);
		return (List<Lessons>)model.getAttribute("insLesson");
	}




		
		
		






}
