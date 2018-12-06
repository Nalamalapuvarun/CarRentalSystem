package model;

public class update_errormsgs {

	private String u_errorMsg;
	private String u_usernameError;
	private String u_nameError;
	private String u_emailError;
	private String u_phonenoError;
	private String u_addressError;
	private String u_curpasswordError;
	private String u_newpasswordError;
	private String u_conpasswordError;
	
	public update_errormsgs () {
		this.u_errorMsg="";
		this.u_usernameError="";
		this.u_nameError="";
		this.u_emailError="";
		this.u_addressError="";
		this.u_phonenoError="";
		this.u_newpasswordError="";
		this.u_conpasswordError="";
		this.u_curpasswordError="";
	}
	public String getU_errorMsg() {
		return u_errorMsg;
	}
	public void setU_errorMsg() {
		if (!u_usernameError.equals("") || !u_nameError.equals("") ||!u_emailError.equals("")||!u_newpasswordError.equals("")||!u_addressError.equals("")
				||!u_phonenoError.equals("") || !u_conpasswordError.equals("") ||!u_curpasswordError.equals(""))
			u_errorMsg="Please correct the following errors";
	}
	public String getU_usernameError() {
		return u_usernameError;
	}
	public void setU_usernameError(String u_usernameError) {
		this.u_usernameError = u_usernameError;
	}
	
	
	public String getU_nameError() {
		return u_nameError;
	}
	public void setU_nameError(String u_nameError) {
		this.u_nameError = u_nameError;
	}
	
	
	public String getU_emailError() {
		return u_emailError;
	}
	public void setU_emailError(String u_emailError) {
		this.u_emailError = u_emailError;
	}
	
	
	public String getU_phonenoError() {
		return u_phonenoError;
	}
	public void setU_phonenoError(String u_phonenoError) {
		this.u_phonenoError = u_phonenoError;
	}
	
	
	public String getU_addressError() {
		return u_addressError;
	}
	public void setU_addressError(String u_addressError) {
		this.u_addressError = u_addressError;
	}
	
	
	public String getU_curpasswordError() {
		return u_curpasswordError;
	}
	public void setU_curpasswordError(String u_curpasswordError) {
		this.u_curpasswordError = u_curpasswordError;
	}
	
	
	public String getU_newpasswordError() {
		return u_newpasswordError;
	}
	public void setU_newpasswordError(String u_newpasswordError) {
		this.u_newpasswordError = u_newpasswordError;
	}
	
	
	public String getU_conpasswordError() {
		return u_conpasswordError;
	}
	public void setU_conpasswordError(String u_conpasswordError) {
		this.u_conpasswordError = u_conpasswordError;
	}
	
	
	
}
