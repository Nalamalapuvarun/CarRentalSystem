package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import model.CancelReservationModel;
import data.CancelReservationDAO;
import model.cancelreservation_errormsgs;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CancelReservationTest {
	//declare variable here
	CancelReservationModel cancel;
	cancelreservation_errormsgs cErrorMsgs;
	
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		cancel = new CancelReservationModel();
		cErrorMsgs = new cancelreservation_errormsgs();
		
	}

	@FileParameters("src/csvfiles/CancelReservation_TestCases.csv")
	@Test
	public void test(int testCaseNumber, String confirmationid, String errorMsg ,String confirmationidError) {

		cancel.setCancelReservationModel(confirmationid);
		//validate
		cancel.validateCancelReservationModel(cancel, cErrorMsgs);
		
		assertEquals(errorMsg,cErrorMsgs.getC_errorMsg());
		assertEquals(confirmationidError,cErrorMsgs.getC_confirmationidError());
		
	    	    
	}
}
