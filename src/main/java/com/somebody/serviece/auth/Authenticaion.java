package com.somebody.serviece.auth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.db.CommonMethod;
import com.somebody.db.MapperBon;
import com.somebody.db.MapperDong;
import com.somebody.db.MapperUone;
import com.somebody.db.MapperYoung;

import beans.Centers;
import beans.Members;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Authenticaion extends CommonMethod {

	@Autowired
	private MapperYoung my;
	@Autowired
	private MapperBon mb;
	@Autowired
	private MapperDong md;
	@Autowired
	private MapperUone mo;
	
	
	private ModelAndView mav;
	@Autowired
	private ProjectUtils pu;
	@Autowired
	private Encryption enc;
	@Autowired
	HttpSession session;
	
	String page = null;
	boolean tran = false;

	public Authenticaion() {
		mav = new ModelAndView();
	}

	public void backController(String sCode, Centers ct) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "A03":
			ctLogin(ct);
			break;
		case "A04":
			logOut(ct);
			break;
		case "A05":
			sendEmailForm(ct);
			break;
		case "A06":
			modPw(ct);
			break;
		case "J01":
			ctJoinForm(ct);
			break;
		case "J02":
			ctJoin(ct);
			break;
		case "P05":
			psJoin(ct);
			break;
		case "P04":
			getSelectCenter(ct);
			break;
		}

	}

	public void backController2(String sCode, Members me) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		case "A02":
			meLogin(me);
			break;
		case "J03":
			goMeJoinPage(me);
			break;
		case "C14":
			checkMePw(me);
			break;
		}
	}
	public void checkMePw(Members me) {
		

	}

	private void goMeJoinPage(Members me) {
		

	}

	public void meLogin(Members me) {

	}

	public void ctLogin(Centers ct) {
		this.tranconfig(TransactionDefinition.PROPAGATION_REQUIRED,TransactionDefinition.ISOLATION_READ_COMMITTED,false);
		if(this.convertToBoolean(this.mb.is(ct))) {
			tran = true;
		}
	this.tranend(tran);
	}

	public void logOut(Centers ct) {

	}

	public void sendEmailForm(Centers ct) {

	}

	public void modPw(Centers ct) {

	}

	public void ctJoinForm(Centers ct) {

	}

	public void ctJoin(Centers ct) {

	}

	public void psJoin(Centers ct) {

	}

	public void getSelectCenter(Centers ct) {

	}

}
