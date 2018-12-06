package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import model.AdminModel;
import model.revoke_errormsgs;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class revokeTest {
	AdminModel revoke;
	revoke_errormsgs rErrorMsgs;
	
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		revoke = new AdminModel();
		rErrorMsgs = new revoke_errormsgs();
		
	}

	@FileParameters("src/csvfiles/revoke.csv")
	@Test
	public void test(int testCaseNumber, String username, String usernameError, String errormsg) {

		revoke.setUsername(username);
		//validate
		revoke.validateAdminModel(revoke, rErrorMsgs);

		assertEquals(usernameError,rErrorMsgs.getR_usernameError());
		assertEquals(errormsg,rErrorMsgs.getR_errorMsg());
	    	    
	}
}
