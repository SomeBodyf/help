package com.somebody.serviece.auth;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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

	Members mme;

	String page = null;
	String message = null;
	boolean tran = false;

	public Authenticaion() {
		mav = new ModelAndView();
		
	}

	public void backController(String sCode, Centers ct) {
		String gs = null;

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

	public void backController2(String sCode, Model model) {

		String gs = null;
		List<Members> senddata = null;

		switch (sCode) {
		
		case "J03":
			goMeJoinPage(model);
			break;
		case "C14":
			checkMePw(model);
			break;
		}

	}
	
	
	public ModelAndView backControllerM(String sCode, Members me) {
		String gs = null;
		List<Members> senddata = null;
		switch (sCode) {
		case "A02":
			meLogin( me);
			break;
		}
		return this.mav;
	}


	public void checkMePw(Model model) {

	}

	private void goMeJoinPage(Model model) {

	}

	public ModelAndView meLogin(Members mme) {

		//아이디비번제어 일치시 로그인기록 저장
		String changedPw = this.enc.encode(mme.getMePw());
	
		System.out.println(mme.getMePw()+"여기비번");
		System.out.println(changedPw);
		

		this.tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED,false);

		try {
			if ((String)this.pu.getAttribute("meInfo") == null) {
				if (changedPw != null) {
				System.out.println(mme.getMeCode());
				System.out.println(this.mb.meLogin(mme)+"s");
				
				
				
				
				if (enc.matches(this.mb.meLogin(mme),changedPw)) {
					System.out.println(11);
					//로그인 기록은 센터만 하기로 함 
					this.mav.addObject("meInfo", this.mb.meInfo(mme));
					tran = true;
					this.tranend(tran);
					pu.setAttribute("meInfo", mme);
					session.setMaxInactiveInterval(30*30) ;
					this.mav.setViewName("meMg");

				}else {
					this.message = "비밀번호가 일치하지 않습니다.";
					this.mav.addObject(this.message);
				}
			}
		}} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.mav;
	}
		

	public void ctLogin(Centers ct) {

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
