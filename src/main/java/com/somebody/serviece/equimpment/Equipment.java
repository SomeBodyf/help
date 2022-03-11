package com.somebody.serviece.equimpment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.db.CommonMethod;
import com.somebody.db.MapperBon;
import com.somebody.db.MapperDong;
import com.somebody.db.MapperUone;
import com.somebody.db.MapperYoung;

import beans.Equipments;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Equipment extends CommonMethod {
	@Autowired
	private MapperBon mb;
	@Autowired
	private MapperDong md;
	@Autowired
	private MapperYoung my;
	@Autowired
	private MapperUone mu;
	private ModelAndView mav;
	@Autowired
	private ProjectUtils pu;
	@Autowired
	private Encryption enc;
	@Autowired
	private DataSourceTransactionManager tx;

	private TransactionStatus txStatus;

	private DefaultTransactionDefinition txdef;

	String page = null;
	
	public Equipment() {
		mav = new ModelAndView();
	}

	public ModelAndView backController1(String sCode, Equipments eq) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "G01":
			goGoodsPage(eq);
			break;
		}
		return mav;
	}

	public void backController(String sCode, Equipments eq, Model md) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "G02":
			goodsMg(eq,md);
			break;
		case "G03":
			searchGoods(eq,md);
			break;
		case "G04":
			getGoodsCode(eq,md);
			break;
		case "G05":
			insGoods(eq,md);
			break;
		case "G07":
			modGoods(eq,md);
			break;

		}
	}

	private void goGoodsPage(Equipments eq) {
		//this.mav.addObject("ctCode", eq.getCtCode());
		mav.addObject("ctCode", "1234567890");
		mav.setViewName("goodsMg");
	}

	public void goodsMg(Equipments eq,Model md) {
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		md.addAttribute("goodsList",  this.my.goodsList(eq));
		tranend(true);
	}

	public void searchGoods(Equipments eq, Model md) {
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		md.addAttribute("searchGoods", this.my.searchGoods(eq));
		tranend(true);
	}

	public void getGoodsCode(Equipments eq, Model md) {


	}

	public void insGoods(Equipments eq, Model md) {

	}

	public void modGoods(Equipments eq, Model md) {

	}
}
