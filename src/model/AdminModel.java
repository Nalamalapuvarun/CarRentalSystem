package model;

import data.UserDAO;

public class AdminModel {

	public String Username;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}
	
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String username) {
		
		this.Username = username;
	}
	public void validateAdminModel(AdminModel admin, revoke_errormsgs adminerrormsgs) {
		adminerrormsgs.setR_usernameError(validaterevokeusername(admin.getUsername()));
		adminerrormsgs.setR_errorMsg();
	}
		private String validaterevokeusername (String Username) {
			UserDAO uu = new UserDAO();
			String result="";
			
			//UserDAO us = new UserDAO();
			if (!stringSize(Username,4,10))
				result= "Your username must between 4 and 10 digits";
			
				else if(uu.finduser(Username)){
					result="Your Username is not in database";}
				else{
						result="";
				}
			
			return result;				
		}
		
		private boolean stringSize(String string, int min, int max) {
			return string.length()>=min && string.length()<=max;
		}
	}

