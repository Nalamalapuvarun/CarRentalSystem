package model;

public class SearchCar_errormsgs {
	
	private String s_errorMsgError;
	private String s_startdateError;
	private String s_enddateError;
	private String s_starttimeError;
	private String s_endtimeError;
	private String s_capacityError;
	
	
	public SearchCar_errormsgs()
	 {
		this.s_errorMsgError="";
		 this.s_startdateError="";
		 this.s_enddateError="";
		 this.s_starttimeError="";
		 this.s_endtimeError="";
		 this.s_capacityError="";
		 
	 }
	public String getS_errorMsg() {
		return s_errorMsgError;
	}
	public void setS_errorMsg() {
		if (!s_startdateError.equals("") || !s_enddateError.equals("") ||!s_starttimeError.equals("")||!s_endtimeError.equals("")||!s_capacityError.equals(""))
				
			s_errorMsgError="Please correct the following errors";
	}
	public String getS_startdateError() {
		return s_startdateError;
	}
	public void setS_startdateError(String s_startdateError) {
		this.s_startdateError = s_startdateError;
	}
	public String getS_enddateError() {
		return s_enddateError;
	}
	public void setS_enddateError(String s_enddateError) {
		this.s_enddateError = s_enddateError;
	}
	public String getS_starttimeError() {
		return s_starttimeError;
	}
	public void setS_starttimeError(String s_starttimeError) {
		this.s_starttimeError = s_starttimeError;
	}
	public String getS_endtimeError() {
		return s_endtimeError;
	}
	public void setS_endtimeError(String s_endtimeError) {
		this.s_endtimeError = s_endtimeError;
	}
	public String getS_capacityError() {
		return s_capacityError;
	}
	public void setS_capacityError(String s_capacityError) {
		this.s_capacityError = s_capacityError;
	}

}
