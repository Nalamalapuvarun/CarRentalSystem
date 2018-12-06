package test;

import model.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import model.user;
import model.ManagerModel;
import model.AdminModel;
//import controller.rentalcontrol;
import data.UserDAO;
import data.ManagerDAO;
import model.UserErrormsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner; 

import model.UserErrormsgs;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class userTest extends controller.rentalcontrol {

	user user1;
	UserErrormsgs UErrorMsgs;
	 
	
	@Before
		public void setUp() throws Exception{
		user1 = new user();
		UErrorMsgs = new UserErrormsgs();
	}
	
	@FileParameters("src/csvfiles/Registration_TestCases1.csv")
	
	@Test
	public void test(int testcaseno,String UserName,String FirstName,String Address,String UtaId,String License,String Email,String Password,String Phone,
String UserError,String FirstError,String IdError,String AdError,String LicenseError,String EmailError,String PassError,String PhoneError,String emsg) {
	user1.setAddress(Address);
		user1.setEmail(Email);
		user1.setFullName(FirstName);
		user1.setLicence(License);
		user1.setPassword(Password);
		user1.setUsername(UserName);
		user1.setPhoneNo(Phone);
		user1.setUTAID(UtaId);
		
		user1.validateUser(user1, UErrorMsgs);
		assertEquals(emsg,UErrorMsgs.getErrorMsg());
		assertEquals(UserError,UErrorMsgs.getUsernameError());
		assertEquals(FirstError,UErrorMsgs.getFirstNameError());
		assertEquals(AdError,UErrorMsgs.getAddressError());
		assertEquals(LicenseError,UErrorMsgs.getLicenseError());
		assertEquals(EmailError,UErrorMsgs.getEmailError());
		assertEquals(PassError,UErrorMsgs.getPasswordError());
		assertEquals(IdError,UErrorMsgs.getUtaidError());
		assertEquals(PhoneError,UErrorMsgs.getPhonenoError());
		//fail("Not yet implemented");
	}

}
