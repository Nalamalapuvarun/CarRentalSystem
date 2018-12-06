package model;

public class revoke_errormsgs {

	private String r_usernameError;
	private String r_errorMsg;
	
	public revoke_errormsgs()
	 {
		 this.r_usernameError="";
		 this.r_errorMsg="";
	 }
	 
	public String getR_usernameError() {
			return r_usernameError;
		}
		public void setR_usernameError(String r_usernameError) {
			this.r_usernameError = r_usernameError;
		}
		
	public String getR_errorMsg() {
			return r_errorMsg;
		}
		public void setR_errorMsg() {
			if (!r_usernameError.equals(""))
				r_errorMsg="Please correct the following errors";
		}
	 
}
