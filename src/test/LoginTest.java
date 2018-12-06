package test;

import static org.junit.Assert.*;


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

@RunWith(JUnitParamsRunner.class)

public class LoginTest extends controller.rentalcontrol {
	
	user user;
	UserErrormsgs errorM;
	 
	
	@Before
		public void setUp() throws Exception{
		user = new user();
		errorM = new UserErrormsgs();
	}
	@FileParameters("src/csvfiles/login3.csv")
	
	@Test
	public void test(int testCaseNumber,String Username,String password,String usernameError,String passwordError,String errormsg ){
		UserDAO u = new UserDAO();
		
		user=u.getUserInfo(Username);
		
		user.setUsername(Username);
		user.setPassword(password);
		user.Checkuser(user, errorM);
		assertEquals(errormsg,errorM.getErrorMsg());
		assertEquals(usernameError,errorM.getUsernameError());
		assertEquals(passwordError,errorM.getPasswordError());
		
		System.out.println("testcase ran successfully");
	}

}
