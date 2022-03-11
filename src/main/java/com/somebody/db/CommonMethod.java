package com.somebody.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class CommonMethod {
	
	@Autowired
	private DataSourceTransactionManager tx;

	private TransactionStatus txStatus;

	private DefaultTransactionDefinition txdef;
	
	public CommonMethod() {
		
		
	}
	
	protected boolean convertToBoolean(int number) {
		return number > 0 ? true : false;
	}
	
	//트랜젝션 환경설정
	protected void tranconfig(int propa, int iso, boolean isread) {
		this.txdef = new DefaultTransactionDefinition();
		this.txdef.setPropagationBehavior(propa);
		this.txdef.setIsolationLevel(iso);
		this.txdef.setReadOnly(isread);
		this.txStatus = this.tx.getTransaction(this.txdef);
	}
	//커밋, 롤백 처리
	protected void tranend(boolean tran) {
		if (tran)
			this.tx.commit(this.txStatus);
		else {
			this.tx.rollback(this.txStatus);
		}
	}
	
	

}
