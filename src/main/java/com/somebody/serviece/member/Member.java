package com.somebody.serviece.member;

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

import beans.Members;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Member extends CommonMethod{
	@Autowired
	private MapperBon mb;
	@Autowired
	private MapperDong md;
	@Autowired
	private MapperYoung my;
	@Autowired
	private MapperUone mu;
	private ModelAndView mav;

	private DataSourceTransactionManager tx;

	private TransactionStatus txStatus;

	private DefaultTransactionDefinition txdef;

	String page = null;

	public void backController(String sCode, Members me) {
		String gs = null;
		String senddata = null;

		switch (sCode) {
		//관리자페이지 접근
		case "M01":
			goMePage(me);
		case "M02":
			meMg(me);
		case "M03":
			searchMeMg(me);
		case "M04":
			 meDetail(me);
		case "M05":
			getCaList(me);
		case "M06":
			addMember(me);
		case "M07":
			modMe(me);
		case "M09":
			insInbody(me);
			break;

			
			//회원페이지 접근
		case "C01":
			infoLine(me);
			break;
		case "C02":
			meDtInfo(me);
			break;
		case "C03":
			meInbodyMg(me);
			break;
		case "C04":
			insTaState(me);
			break;
		case "C05":
			meHealthMg(me);
			break;
		case "C06":
			meFoodMg(me);
			break;
		case "C07":
			meLessonMg(me);
			break;
		case "C08":
			getLessonList(me);
			break;
		case "C09":
			searchLsMg(me);
			break;
		case "C10":
			insMeLesson(me);
			break;
		case "C11":
			delMeLesson(me);
			break;
		case "C12":
			meConfig(me);
			break;
		
		case "C15":
			modMeMg(me);
			break;
		case "C17":
			delMe(me);
			break;

		}
	}

	public void goMePage(Members me) {
	
		
	}

	public void meInbodyMg(Members me) {

	}

	public void meDtInfo(Members me) {

	}

	public void meMg(Members me) {

	}

	public void searchMeMg(Members me) {

	}

	public void meDetail(Members me) {

	}

	public void getCaList(Members me) {

	}

	public void addMember(Members me) {

	}

	public void modMe(Members me) {

	}

	public void insInbody(Members me) {

	}

	public void insTaState(Members me) {

	}

	public void meHealthMg(Members me) {

	}

	public void meFoodMg(Members me) {

	}

	public void meLessonMg(Members me) {

	}

	public void getLessonList(Members me) {

	}

	public void searchLsMg(Members me) {

	}

	public void insMeLesson(Members me) {

	}

	public void delMeLesson(Members me) {

	}

	public void meConfig(Members me) {

	}

	

	public void modMeMg(Members me) {

	}

	public void delMe(Members me) {

	}

	public void infoLine(Members me) {

	}

	
	
}
