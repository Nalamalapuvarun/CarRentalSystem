package test;

import model.user;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import model.user;
import model.ManagerModel;
import model.SearchCar_errormsgs;
import model.Searchcar;
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

public class searchcartest extends controller.SearchFunction {
	Searchcar sc;
	SearchCar_errormsgs se;
	
	@Before
	public void setUp() throws Exception{

		sc = new Searchcar();
		se = new SearchCar_errormsgs();

}

	@FileParameters("src/csvfiles/search.csv")

	@Test
	public void test(int testcaseno,String stdate,String enddate,String sttime,String endtime,String capacity,String searcherror,String stdateerror,String enddateerror,
			String sttimeerror,String endtimeerror,String capacityerror) throws ParseException
    
	
	{
	sc.setStartDate(stdate);
	sc.setEndDate(enddate);
	sc.setStartTime(sttime);
	sc.setEndTime(endtime);
	sc.setPassengers(capacity);
	sc.validatesearch(sc, se);
	
	assertEquals(searcherror,se.getS_errorMsg());
	assertEquals(stdateerror,se.getS_startdateError());
	assertEquals(enddateerror,se.getS_enddateError());
	assertEquals(sttimeerror,se.getS_starttimeError());
	assertEquals(capacityerror,se.getS_capacityError());
	}}