package model;

public class cancelreservation_errormsgs {
	
	private String c_errorMsg;
	private String c_confirmationidError;
	
	public cancelreservation_errormsgs() {
		 this.c_errorMsg="";
		 this.c_confirmationidError="";
	 }
	public String getC_errorMsg() {
			return c_errorMsg;
	}
	public void setC_errorMsg() {
		if (!c_confirmationidError.equals(""))
			c_errorMsg="Please correct the following errors";
	}
	public String getC_confirmationidError() {
		return c_confirmationidError;
	}
	public void setC_confirmationidError(String c_confirmationidError) {
		this.c_confirmationidError = c_confirmationidError;
	}
	 
}
