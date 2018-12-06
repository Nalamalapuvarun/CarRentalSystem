package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CarRenterFunction {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void Login ( WebDriver driver, String UserName, String Password){
		driver.findElement(By.id(prop.getProperty("Txt_Login_Username"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Username"))).sendKeys(UserName);
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(Password);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
	}
	
	public void Search(WebDriver driver, String StartDate, String EndDate, String StartTime, String EndTime, String Capacity){

		
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_StartDate"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_StartDate"))).sendKeys(StartDate);
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_EndDate"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_EndDate"))).sendKeys(EndDate);
	   
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_StartTime"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_StartTime"))).sendKeys(StartTime);
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_EndTime"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_EndTime"))).sendKeys(EndTime);
	   
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_Capacity"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchCar_Capacity"))).sendKeys(Capacity);
	    driver.findElement(By.name(prop.getProperty("Btn_SearchCar_Search"))).click();
	    
	}
	public void ReserveCar(WebDriver driver, String CarType, String CardName,String Extras, String CardNumber, String ExpirationDate, String Cvv){
		
		//new Select(driver.findElement(By.xpath(prop.getProperty("Lst_Payment_CarType")))).selectByVisibleText(CarType);
		 //new Select(driver.findElement(By.xpath(prop.getProperty("Lst_Payment_CardName")))).selectByVisibleText(CardName);
	    driver.findElement(By.name("GPS")).click();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_CardNumber"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_CardNumber"))).sendKeys(CardNumber);
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_ExpirationDate"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_ExpirationDate"))).sendKeys(ExpirationDate);
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_Cvv"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Payment_Cvv"))).sendKeys(Cvv);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Payment_BookMyCar"))).click();
	    
	    //driver.findElement(By.linkText(prop.getProperty("Lnk_SearchCar_homepage"))).click();
	    //driver.findElement(By.linkText(prop.getProperty("Lnk_Booked_GotoHomePage"))).click();
	    
	    }

	
	
	
	public void ManagerAddCar(WebDriver driver, String carname, String Capacity, String gps, String OnStar, 
			String SiriusXM, String weekday,String weekend, String week){
		
	  
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_CarName"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_CarName"))).sendKeys(carname);
	    driver.findElement(By.name(prop.getProperty("Txt_AddCar_Capacity"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_AddCar_Capacity"))).sendKeys(Capacity);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_GPS"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_GPS"))).sendKeys(gps);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_OnStar"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_OnStar"))).sendKeys(OnStar);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_SiriusXM"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_SiriusXM"))).sendKeys(SiriusXM);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_weekday"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_weekday"))).sendKeys(weekday);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_WeekEnd"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_WeekEnd"))).sendKeys(weekend);
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_Week"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_AddCar_Week"))).sendKeys(week);
	    //driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
	    driver.findElement(By.xpath(prop.getProperty("Btn_Addcar"))).click();
	
	}
	public void AdminRevokeRenter(WebDriver driver, String Username){
		 driver.findElement(By.xpath(prop.getProperty("Txt_RevokeRenter_UserName"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Txt_RevokeRenter_UserName"))).sendKeys(Username);
		  //  driver.findElement(By.xpath(prop.getProperty("Btn_RevokeRenter_Revoke"))).click();
	}

}
