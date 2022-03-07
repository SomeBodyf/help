package com.somebody.serviece.equimpment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
	
	public void backController(String sCode, Equipments eq) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "G01":
			goGoodsPage(eq);
			 break;
		case "G02":
			goodsMg(eq);
			 break;
		case "G03":
			searchGoods(eq);
			break;
		case "G04":
			getGoodsCode(eq);
			break;
		case "G05":
			insGoods(eq);
			break;
		case "G07":
			modGoods(eq);
			break;
		
		}
		
	}

	private void goGoodsPage(Equipments eq) {
		
	}

	public void goodsMg(Equipments eq) {
		
		
	}

	public void searchGoods(Equipments eq) {
		
	}

	public void getGoodsCode(Equipments eq) {
	
		
	}

	public void insGoods(Equipments eq) {
	
	}

	public void modGoods(Equipments eq) {
	
	}
}
