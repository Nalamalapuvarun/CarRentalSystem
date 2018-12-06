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
import model.PaymentModel;
import model.SearchCar_errormsgs;
import model.Searchcar;
import model.AdminModel;
//import controller.rentalcontrol;
import data.UserDAO;
import data.ManagerDAO;
import model.UserErrormsgs;
import model.payment_errormsgs;
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
public class paymenttest extends controller.SearchFunction {
	PaymentModel pm ;
	payment_errormsgs pe;
	@Before
	public void setUp() throws Exception{

		pm = new PaymentModel();
		pe = new payment_errormsgs();

}

	@FileParameters("src/csvfiles/payment.csv")

	@Test
	public void test(int testcaseno,String cardno,String cvvno,String expirydate,String paymenterror,String cardnoerror,String cvvnoerror,
			String expirydateerror) 
    
	
	{
	pm.setCardno(cardno);
	pm.setCvvno(cvvno);
	pm.setExpirationdate(expirydate);
	
	pm.validatePaymentModel(pm, pe);
	
	assertEquals(paymenterror,pe.getP_errorMsg());
	assertEquals(cardnoerror,pe.getP_cardnoError());
	assertEquals(cvvnoerror,pe.getP_cvvnoError());
	assertEquals(expirydateerror,pe.getP_expirationdateError());
	
	}}
	

