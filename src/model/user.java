package model;

import data.UserDAO;

public class user {
	private String Username ;
	private String Password ;
	private String fullName ;
	private String Role ;
	private String Licence ;
	private String DOB ;
	private String email ;
	private String PhoneNo ;
	private String Address ;
	private String UTAID ;
	private String AutoClub ;
	//private String Age;

//	public String getAge() {
//		return Age;
//	}
//
//	public void setAge(String age) {
//		Age = age;
//	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user(String username, String password, String fullName, String role, String licence, String dOB,
			String email, String phoneNo, String address, String uTAID, String autoClub) {
		super();
		Username = username;
		Password = password;
		this.fullName = fullName;
		Role = role;
		Licence = licence;
		DOB = dOB;
		this.email = email;
		PhoneNo = phoneNo;
		Address = address;
		UTAID = uTAID;
		AutoClub = autoClub;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getLicence() {
		return Licence;
	}

	public void setLicence(String licence) {
		Licence = licence;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String string) {
		PhoneNo = string;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUTAID() {
		return UTAID;
	}

	public void setUTAID(String uTAID) {
		UTAID = uTAID;
	}

	public String getAutoClub() {
		return AutoClub;
	}

	public void setAutoClub(String autoClub) {
		AutoClub = autoClub;
	}
	public void validateUser(user user, UserErrormsgs errorMsgs) {
		errorMsgs.setUsernameError(validateusername(user.getUsername()));
		errorMsgs.setFirstNameError(validateFirstName(user.getFullName()));
		errorMsgs.setUtaidError(validateUtaId(user.getUTAID()));
		errorMsgs.setAddressError(validateAddress(user.getAddress()));
		errorMsgs.setLicenseError(validatelicense(user.getLicence()));
		errorMsgs.setPasswordError(validatepassword(user.getPassword()));
		errorMsgs.setEmailError(validateemail(user.getEmail()));
		errorMsgs.setPhonenoError(validatephoneno(user.getPhoneNo()));
		//errorMsgs.setAgeError(validateAge(user.getAge()));
		errorMsgs.setErrorMsg();
	}
	
	public String validateusername (String Username) {
		String result="";
		user u=new user();
		UserDAO us = new UserDAO();
		String pswd=u.getPassword();
		if (!stringSize(Username,4,10))
			result= "Your username must between 4 and 10 digits";
		
			
			else
			   if (!us.finduser(Username))
					result="Username already in database";
			   else
				   result="";
		return result;				
	}
	
//	public String validateAge(String age)
//	{
//		String result="";
//		if(age.isEmpty())
//		{
//			result="the age cannot be empty";
//		}
//		else if(!isTextAnInteger(UTAID))
//		{
//			result="the age must be a number and an integer";
//		}
//		else if(!stringSize(age,1,3))
//		{
//			result="age must be between 1 and 3 characters";
//			
//		}
//		else
//		{
//			result="";
//		}
//	return result;
//	}
	

	public String validateFirstName (String fullName) {
		String result="";
		if (!stringSize(fullName,1,20))
			result= "Your Full Name must between 1 and 20 characters";
		else
			if (Character.isLowerCase(fullName.charAt(0)))
				result="Your First Name must start with a capital letter";
			else
				result="";
		return result;
	}
	
	public String validateAddress (String Address) {
		String result="";
		if (!stringSize(Address,1,10))
			{result= "Your Address must between 1 and 10 characters";}
		else if (Character.isLowerCase(Address.charAt(0)))
				{result="Your Address must start with a capital letter";}
		else
			{result="";}
		return result;
	}

	public String validateUtaId (String UTAID) {
		String result="";
		if (UTAID.length()!=10)
			{result= "Your UTA ID must be 10 digits";}
		else
			if (!isTextAnInteger(UTAID))
				{result="Your UtaID must be a number";}
			else 
				{result="";}
		return result;
	}
	public String validateemail(String email)
	{
		String result="";
		if(!stringSize(email,8,40))
		{
			result="Your email must be between 12 and 40 characters";
		}
		else if(!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.com|.net|.org|.mil|.gov|.edu)$"))
		{
			result="your email must have @ and proper extensions";
		}		
		
		else
			result="";
		return result;
 	}
	public String validatephoneno(String phoneno)
	{   String result="";
		if(phoneno.length()!=10)
		{
			result="please enter the 10 digit phone number";
		}
		else if(!isTextAnInteger(phoneno))
		{
			result="you just have to enter numbers";
			
		}
		else
			result="";
		return result;
	}
	
	
	public boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	public boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	
  public String validatelicense(String license)
  {  String result="";
	  if (license.length()!=8)
			result= "Your license must be 8 digits";
		//else
			//if (!isAlphanumeric(license))
				//result="Your license must be alphanumeric";
	  
			   else
				   result="";
		return result;		
	  
	  
	  
  }
  
  public String validatepassword(String password)
  {
	  String result="";
	  if (!stringSize(password,6,10))
			{result= "Your password must atleast contain one 1 uppercase,1 lowercase and 1 number";}
	  //else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$"))
		// {result="Your password must atleast contain one 1 uppercase,1 lowercase and 1 special character and 1 number";}
	  else 
		  {result="";}
	  return result;
	       
  }
  
  public void  Checkuser(user user,UserErrormsgs errormsgs)
  {   System.out.println("In user " + user.getUsername());
	  errormsgs.setUsernameError(verifyloginuser(user.getUsername()));
	  errormsgs.setPasswordError(verifyloginpassword(user.getPassword(),user.getUsername()));
	  errormsgs.setErrorMsg();
	  
  }
  
  
  public String verifyloginuser(String username)
  {
	  String result="";
	  UserDAO u = new UserDAO();
	  if(username.isEmpty())
	  {
		  result="You cant leave username empty";
	  }
	  else if(u.finduser(username))
	  {
		  result="The username is not yet registered";
	  }
	  
	  else
		  {result="";}
	  return result;
  }
  
  public String verifyloginpassword(String password,String uname)
  {
	  String result="";
	  UserDAO usi = new UserDAO();
	 if(password.isEmpty())
	 {
		 result="You cant leave password empty";
	 }
  
	 //else if(!usi.finduser(uname))
	 else if(usi.authentecateUser(uname, password) == 0){
		 
		 result="Please Enter the correct password";
		 
	 }
	
  
	 else
	 { result="";}
	 
	 return result;
	 
	 
  }
  
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

}