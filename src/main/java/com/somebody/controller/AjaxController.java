package com.somebody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
	@@ -41,103 +43,103 @@ public AjaxController(){}

	//Bon
	@RequestMapping(value = "/modPw", method = RequestMethod.POST)
	public void modPw(Model model, @RequestBody Centers ct) {
		this.auth.backController("A06", ct);
	}
	@RequestMapping(value = "/meMg", method = RequestMethod.POST)
	public void meMg(Model model, @RequestBody Members me) {
		this.me.backController("M01",me);
	}

	@RequestMapping(value = "/searchMeMg", method = RequestMethod.POST)
	public void searchMeMg(Model model, @RequestBody Members me) {
		this.me.backController("M02",me);
	}

	@RequestMapping(value = "/meDetail", method = RequestMethod.POST)
	public void meDetail(Model model, @RequestBody Members me) {
		this.me.backController("M03",me);
	}

	@RequestMapping(value = "/getCaList", method = RequestMethod.POST)
	public void getCaList(Model model, @RequestBody Members me) {
		this.me.backController("M04", me);
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public void addMember(Model model, @RequestBody Members me) {
		this.me.backController("M06",me);
	}

	@RequestMapping(value = "/modMe", method = RequestMethod.POST)
	public void modMe(Model model, @RequestBody Members me) {
		this.me.backController("M07", me);

	}

	@RequestMapping(value = "/insInbody", method = RequestMethod.POST)
	public void insInbody(Model model, @RequestBody Members me) {
		this.me.backController("M09", me);
	}



	//Dong
	@RequestMapping(value = "/sfMg", method = RequestMethod.POST)
	public void sfMg(Model model, @RequestBody Staff sf) {
		this.sf.backController("S01", sf);
	}
	@RequestMapping(value = "/searchSfMg", method = RequestMethod.POST)
	public void searchSfMg(Model model, @RequestBody Staff sf) {
		this.sf.backController("S02", sf);
	}
	@RequestMapping(value = "/getMaxSf", method = RequestMethod.POST)
	public void getMaxSf(Model model, @RequestBody Staff sf) {
		this.sf.backController("S03", sf);
	}
	@RequestMapping(value = "/insSf", method = RequestMethod.POST)
	public void insSf(Model model, @RequestBody Staff sf) {
		this.sf.backController("S04", sf);
	}
	@RequestMapping(value = "/modSf", method = RequestMethod.POST)
	public void modSf(Model model, @RequestBody Staff sf) {
		this.sf.backController("S07", sf);
	}
	@RequestMapping(value = "/getMeMg", method = RequestMethod.POST)
	public void getMeMg(Model model, @RequestBody Staff sf) {
		this.sf.backController("S09", sf);
	}

	@RequestMapping(value = "/lessonMg", method = RequestMethod.POST)
	public void lessonMg(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L02",ls);
	}
	@RequestMapping(value = "/searchLesson", method = RequestMethod.POST)
	public void searchLesson(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L03",ls);
	}
	@RequestMapping(value = "/getLsCaList", method = RequestMethod.POST)
	public void getLsCaList(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L04",ls);
	}
	@RequestMapping(value = "/insLsPay", method = RequestMethod.POST)
	public void insLsPay(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L05",ls);
	}
	@RequestMapping(value = "/getMaxLesson", method = RequestMethod.POST)
	public void getMaxLesson(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L06",ls);
	}
	@RequestMapping(value = "/insLesson", method = RequestMethod.POST)
	public void insLesson(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L07",ls);
	}



	//Young
	@RequestMapping(value = "/modLesson", method = RequestMethod.POST)
	public void modLesson(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L09",ls);
	}
	@RequestMapping(value = "/lsMemDetail", method = RequestMethod.POST)
	@@ -146,99 +148,101 @@ public void lsMemDetail() {
	}

	@RequestMapping(value = "/modLsSuccess", method = RequestMethod.POST)
	public void modLsSuccess(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L11",ls);
	}
	@RequestMapping(value = "/delLesson", method = RequestMethod.POST)
	public void delLesson(Model model, @RequestBody Lesson ls) {
		this.ls.backController("L12",ls);
	}
	@RequestMapping(value = "/goodsMg", method = RequestMethod.POST)
	public List<Equipments> goodsMg(Model model, @RequestBody Equipments[] eq) {
		this.eq.backController("G02",eq[0], model);
		return (List<Equipments>) model.getAttribute("goodsList");
	}

	@RequestMapping(value = "/searchGoods", method = RequestMethod.POST)
	public List<Equipments> searchGoods(Model model, @RequestBody Equipments[] eq) {
		this.eq.backController("G03",eq[0], model);
		return (List<Equipments>) model.getAttribute("searchGoods");
	}

	@RequestMapping(value = "/getGoodsCode", method = RequestMethod.POST)
	public void getGoodsCode(Model model, @RequestBody Equipments[] eq) {
		this.eq.backController("G04", eq[0], model);
	}
	@RequestMapping(value = "/insGoods", method = RequestMethod.POST)
	public void insGoods(Model model, @RequestBody Equipments[] eq) {
		this.eq.backController("G05", eq[0], model);
	}
	@RequestMapping(value = "/modGoods", method = RequestMethod.POST)
	public void modGoods(Model model, @RequestBody Equipments[] eq) {
		this.eq.backController("G07", eq[0], model);
	}

	@RequestMapping(value = "/onLoadPay", method = RequestMethod.POST)
	public void onLoadPay(Model model, @RequestBody Pays pa) {
		this.pa.backController("P02", pa);
	}

	@RequestMapping(value = "/searchPay", method = RequestMethod.POST)
	public void searchPay(Model model, @RequestBody Pays pa) {
		this.pa.backController("P03", pa);
	}
	@RequestMapping(value = "/goMeJoinPage", method = RequestMethod.POST)
	public void goMeJoinPage(Model model, @RequestBody Members me) {
		this.auth.backController2("J03", me);
	}



	//UONE
	@RequestMapping(value = "/infoLine", method = RequestMethod.POST)
	public void infoLine(Model model, @RequestBody Members me) {
		this.me.backController("C01",me);
	}
	@RequestMapping(value = "/meDtInfo", method = RequestMethod.POST)
	public void meDtInfo(Model model, @RequestBody Members me) {
		this.me.backController("C02",me);
	}
	@RequestMapping(value = "/meInbodyMg", method = RequestMethod.POST)
	public void meInbodyMg(Model model, @RequestBody Members me) {
		this.me.backController("C03", me);
	}
	@RequestMapping(value = "/insTaState", method = RequestMethod.POST)
	public void insTaState(Model model, @RequestBody Members me) {
		this.me.backController("C04",me);
	}
	@RequestMapping(value = "/meHealthMg", method = RequestMethod.POST)
	public void meHealthMg(Model model, @RequestBody Members me) {
		this.me.backController("C05",me);
	}
	@RequestMapping(value = "/meFoodMg", method = RequestMethod.POST)
	public void meFoodMg(Model model, @RequestBody Members me) {
		this.me.backController("C06",me);
	}
	@RequestMapping(value = "/getLessonList", method = RequestMethod.POST)
	public void getLessonList(Model model, @RequestBody Members me) {
		this.me.backController("C08",me);
	}
	@RequestMapping(value = "/searchLsMg", method = RequestMethod.POST)
	public void searchLsMg(Model model, @RequestBody Members me) {
		this.me.backController("C09",me);
	}
	@RequestMapping(value = "/insMeLesson", method = RequestMethod.POST)
	public void insMeLesson(Model model, @RequestBody Members me) {
		this.me.backController("C10",me);
	}
	@RequestMapping(value = "/delMeLesson", method = RequestMethod.POST)
	public void delMeLesson(Model model, @RequestBody Members me) {
		this.me.backController("C11",me);
	}
	@RequestMapping(value = "/checkMePw", method = RequestMethod.POST)
	public void checkMePw(Model model, @RequestBody Members me) {
		this.auth.backController2("C14",me);
	}
	@RequestMapping(value = "/modMeMg", method = RequestMethod.POST)
	public void modMeMg(Model model, @RequestBody Members me) {
		this.me.backController("C15",me);
	}
