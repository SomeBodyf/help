package com.somebody.serviece.pay;

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

import beans.Pays;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Pay extends CommonMethod{
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
	private DataSourceTransactionManager tx;

	private TransactionStatus txStatus;

	private DefaultTransactionDefinition txdef;

	String page = null;

	public void backController(String sCode, Pays pa) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "P01":
			payMg(pa);
			break;
		case "P02":
			onLoadPay(pa);
			break;
		case "P03":
			searchPay(pa);
			break;
		}
	}

	public void payMg(Pays pa) {
	}

	public void onLoadPay(Pays pa) {
	}

	public void searchPay(Pays pa) {
	}

}
