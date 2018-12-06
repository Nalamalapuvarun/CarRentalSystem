package model;

public class UpdateProfileModel {
	//private String Username ;
	private String curpassword ;
	private String newpassword ;
	//private String conpassword ;
	private String fullName ;
	private String email ;
	private String PhoneNo ;
	private String addr ;

//
//	public String getUsername() {
//		return Username;
//	}
//
//	public void setUsername(String username) {
//		Username = username;
//	}

	public String getcurpassword() {
		return curpassword;
	}

	public void setcurpassword(String curpassword) {
		this.curpassword = curpassword;
	}
	
	public String getnewpassword() {
		return newpassword;
	}

	public void setnewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
//	public String getconpassword() {
//		return conpassword;
//	}
//
//	public void setconpassword(String conpassword) {
//		this.conpassword = conpassword;
//	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getaddr() {
		return addr;
	}

	public void setaddr(String addr) {
		this.addr = addr;
	}
	public UpdateProfileModel(String username, String fullName, String email, String phoneNo, String addr,
			String curpassword, String newpassword, String conpassword) {
		super();
		//Username = username;
		this.curpassword = curpassword;
		this.newpassword = newpassword;
		//this.conpassword = conpassword;
		this.fullName = fullName;
		this.email = email;
		PhoneNo = phoneNo;
		this.addr = addr;
	}
    
	public UpdateProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void validateUpdateProfile(UpdateProfileModel update, update_errormsgs updateerrorMsgs) {
		
		updateerrorMsgs.setU_nameError(validateupdatename(update.getFullName()));
		updateerrorMsgs.setU_addressError(validateupdateaddress(update.getaddr()));
		updateerrorMsgs.setU_curpasswordError(validateupdatecurpassword(update.getcurpassword()));
		updateerrorMsgs.setU_newpasswordError(validateupdatenewpassword(update.getnewpassword()));
		//updateerrorMsgs.setU_conpasswordError(validateupdateconpassword(update.getconpassword()));
		updateerrorMsgs.setU_emailError(validateupdateemail(update.getEmail()));
		updateerrorMsgs.setU_phonenoError(validateupdatephoneno(update.getPhoneNo()));
		updateerrorMsgs.setU_errorMsg();
	}
//	private boolean isAlphanumeric(String username2) {
//		// TODO Auto-generated method stub
//		boolean s1;
//		s1=username2.matches("[a-zA-Z0-9]+");
//		
//		return s1;
//	}

	private String validateupdatename (String fullName) {
		String result="";
		if (!stringSize(fullName,1,20))
			result= "Your Full Name must between 1 and 20 digits";
		else
			if (Character.isLowerCase(fullName.charAt(0)))
				result="Your First Name must start with a capital letter";
			else
				result="";
		return result;
	}
	
	private String validateupdateaddress (String Address) {
		String result="";
		if (!stringSize(Address,1,10))
			{result= "Your Address must between 1 and 100 Characters";}
		else if (Character.isLowerCase(Address.charAt(0)))
				{result="Your Address must start with a capital letter";}
		else
			result="";
		return result;
	}

	private String validateupdateemail(String email)
	{
		String result="";
		if(!stringSize(email,12,40))
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
	private String validateupdatephoneno(String phoneno)
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
	
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
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

  
  private String validateupdatecurpassword(String password)
  {
	  String result="";
	  if (!stringSize(password,6,10))
			{result= "Your password must between 6 and 10 digits";}
	 // else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@._#$%^&+=])$"))
		//  {result="Your password must atleast contain one 1 uppercase,1 lowercase and 1 special character and 1 number";}
	  else 
		  {result="";}
	  return result;
	       
  }
  private String validateupdatenewpassword(String password)
  {
	  String result="";
	  if (!stringSize(password,6,10))
			{result= "Your password must between 6 and 10 digits";}
	 // else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@._#$%^&+=])$"))
		//  {result="Your password must atleast contain one 1 uppercase,1 lowercase and 1 special character and 1 number";}
	  else 
		  {result="";}
	  return result;
	       
  }
//  private String validateupdateconpassword(String password)
//  {
//	  String result="";
//	  System.out.println("The PASS PASSED IS " + password);
//	  UpdateProfileModel u = new UpdateProfileModel();
//	  if(!(u.getnewpassword().equals(password)))
//	  {
//		  
//		  result="Please enter the correct new password";
//		  
//		  
//	  }
//	  else
//	  {
//		  result="";
//	  }
//	  
//	  return result;
//	       
//  }
  
  

}
