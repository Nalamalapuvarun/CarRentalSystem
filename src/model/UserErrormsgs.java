package model;

public class UserErrormsgs {

	

		private String errorMsg;
		private String usernameError;
		private String firstNameError;
		//private String AddressError;
		private String utaidError; 
		private String ageError;






		






		private String emailError;
		private String passwordError;
		
		private String addressError;
		





		private String phonenoError;
		private String licenseError;
		
		public UserErrormsgs () {
			this.errorMsg="";
			this.usernameError="";
			this.firstNameError="";
			//this.AddressError="";
			this.utaidError="";
			this.emailError="";
			this.passwordError="";
			this.addressError="";
			this.phonenoError="";
			this.licenseError="";
		}
		
		

	


		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg() {
			if (!usernameError.equals("") || !firstNameError.equals("") ||  !utaidError.equals("")||!emailError.equals("")||!passwordError.equals("")||!addressError.equals("")
					||!phonenoError.equals("")||!licenseError.equals(""))
				errorMsg="Please correct the following errors";
		}
		
		public String getUsernameError() {
			return usernameError;
		}

		public void setUsernameError(String usernameError) {
			this.usernameError = usernameError;
		}

		//public String getAddressError() {
			//return AddressError;
		//}

		//public void setAddressError(String addressError) {
			//AddressError = addressError;
		//}

		

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}
		public String getFirstNameError() {
			return firstNameError;
		}



		public void setFirstNameError(String firstNameError) {
			this.firstNameError = firstNameError;
		}
		public String getPasswordError() {
			return passwordError;
		}

		public String getUtaidError() {
			return utaidError;
		}






		public void setUtaidError(String utaidError) {
			this.utaidError = utaidError;
		}




		public void setPasswordError(String passwordError) {
			this.passwordError = passwordError;
		}
		public String getEmailError() {
			return emailError;
		}






		public void setEmailError(String emailError) {
			this.emailError = emailError;
		}






		public String getAddressError() {
			return addressError;
		}






		public void setAddressError(String addressError) {
			this.addressError = addressError;
		}






		public String getPhonenoError() {
			return phonenoError;
		}






		public void setPhonenoError(String phonenoError) {
			this.phonenoError = phonenoError;
		}






		public String getLicenseError() {
			return licenseError;
		}






		public void setLicenseError(String licenseError) {
			this.licenseError = licenseError;
		}

		public String getAgeError() {
			return ageError;
		}






		public void setAgeError(String ageError) {
			this.ageError = ageError;
		}
		

	
}

