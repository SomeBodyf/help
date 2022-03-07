package beans;

import java.util.List;

import lombok.Data;

@Data
public class Members {
	private String meCode;
	private String meName;
	private String meBirth;
	private String meEmail;
	private String meNumber;
	private String meGender;
	private String mePw;
	private String meCaCode;
	
	//Excercise, locker
	private String meExCode;
	private String meExName;
	private String meExUnit;
	private String Locker;	
	
	//Target
	private String daCode;
	private String exCode;
	private String peDate;
	private String stCode;
	

}
