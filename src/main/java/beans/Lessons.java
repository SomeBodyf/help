package beans;

import lombok.Data;

@Data
public class Lessons {
	private String ctCode;
	private String sfCode;
	private String sfName;
	private String lsCode;
	private String lsName;
	private String lsOpen;
	private String lsProgress;
	private String lsmeCount;
	private String lsCaCode;
	private String lsCaName;
	
	//수업예약
	
	
	//수업결제
	private String lpCaCode;
	private String lpQty;
	private String lpPrice;
	
}
