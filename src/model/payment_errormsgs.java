package model;

public class payment_errormsgs {
	private String p_errorMsg; 
	
	private String p_cardnoError;
	private String p_expirationdateError;
	private String p_cvvnoError;
	
	public payment_errormsgs(String p_errorMsg, String p_cardtypeError, String p_cardnoError,
			String p_expirationdateError, String p_cvvnoError) {
		super();
		this.p_errorMsg = p_errorMsg;
				this.p_cardnoError = p_cardnoError;
		this.p_expirationdateError = p_expirationdateError;
		this.p_cvvnoError = p_cvvnoError;
	}
	
	public String getP_cardnoError() {
		return p_cardnoError;
	}
	public void setP_cardnoError(String p_cardnoError) {
		this.p_cardnoError = p_cardnoError;
	}
	public String getP_expirationdateError() {
		return p_expirationdateError;
	}
	public void setP_expirationdateError(String p_expirationdateError) {
		this.p_expirationdateError = p_expirationdateError;
	}
	public String getP_cvvnoError() {
		return p_cvvnoError;
	}
	public void setP_cvvnoError(String p_cvvnoError) {
		this.p_cvvnoError = p_cvvnoError;
	}
	public payment_errormsgs() {
		super();
		this.p_errorMsg = "";
		
		this.p_cardnoError = "";
		this.p_expirationdateError = "";
		this.p_cvvnoError = "";
	}

	public String getP_errorMsg() {
		return p_errorMsg;
	}
	public void setP_errorMsg() {
		if ( !p_cardnoError.equals("") || !p_expirationdateError.equals("")||!p_cvvnoError.equals(""))
			p_errorMsg="Please correct the following errors";
	}
	
}
