package test;

import static org.junit.Assert.*;
import model.update_errormsgs;
import model.UpdateProfileModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class UpdateProfileTest {
	UpdateProfileModel update;
	update_errormsgs update_error;

	@Before
	public void setUp() throws Exception {
		update = new UpdateProfileModel();
		update_error = new update_errormsgs();
	}
	@FileParameters("src/csvfiles/UpdateProfile_testcases.csv")
	@Test
	public void test(int testcaseno,String UserName,String Address,String CurPassword,String NewPassword,String Email,String Phone,
String ErrorMsg,String NameError,String AdError,String CurPasswordError,String NewPasswordError,String EmailError,String PhoneError) {
		update.setFullName(UserName);
		update.setaddr(Address);
		update.setcurpassword(CurPassword);
		update.setnewpassword(NewPassword);
		update.setEmail(Email);
		update.setPhoneNo(Phone);
		//System.out.println(update.get);
		update.validateUpdateProfile(update, update_error);
		assertEquals(ErrorMsg,update_error.getU_errorMsg());
		assertEquals(NameError,update_error.getU_nameError());
		assertEquals(AdError,update_error.getU_addressError());
		assertEquals(CurPasswordError,update_error.getU_curpasswordError());
		assertEquals(NewPasswordError,update_error.getU_newpasswordError());
		assertEquals(EmailError,update_error.getU_emailError());
		assertEquals(PhoneError,update_error.getU_phonenoError());
		//fail("Not yet implemented");
	}

}
