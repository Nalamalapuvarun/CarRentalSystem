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
import model.AddCarModel;
import model.addcar_errormsgs;
import data.UserDAO;
import data.ManagerDAO;
import model.UserErrormsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)





public class addcartest extends controller.ManagerController {
	AddCarModel addc;
	addcar_errormsgs addcarError;
	
	
	@Before
	public void setUp() throws Exception{
	addc = new AddCarModel();
	addcarError = new addcar_errormsgs();
}

@FileParameters("src/csvfiles/addcar4.csv")
	
	@Test
	public void test(int testCaseNumber,String CarName,String capacity,String weekday,String weekend,String week,String gps,String Onstar,String SiriusXm,String errorms,String CarNameerror,String capacityerror,String weekdayerror,String weekenderror,String weekerror,String gpserror, String onstarerror,String Siriusxmerror){
		addc.setCarName(CarName);
		addc.setCapacity(capacity);
		addc.setGps(gps);
		addc.setOnStar(Onstar);
		addc.setSiriusXM(SiriusXm);
		addc.setWeekDay(weekday);
		addc.setWeek(week);
		addc.setWeekEnd(weekend);
		
		addc.validateAddCarModel(addc, addcarError);
		assertEquals(errorms,addcarError.getA_errorMsg());
		assertEquals(CarNameerror,addcarError.getA_CarNamError());
		assertEquals(capacityerror,addcarError.getA_CapacityError());
		assertEquals(gpserror,addcarError.getA_GpsError());
		assertEquals(onstarerror,addcarError.getA_OnStarError());
		assertEquals(Siriusxmerror,addcarError.getA_SiriusXMError());
		assertEquals(weekdayerror,addcarError.getA_WeekDayError());
		assertEquals(weekenderror,addcarError.getA_WeekEndError());
		assertEquals(weekerror,addcarError.getA_WeekError());
		
		System.out.println("testcase ran successfully");
	}
	
	
}
