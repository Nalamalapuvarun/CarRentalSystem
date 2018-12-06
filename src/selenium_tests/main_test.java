package selenium_tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import java.io.FileInputStream;
import functions.CarRenterFunction;


public class main_test extends CarRenterFunction {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath;

  @Before
  public void setUp() throws Exception {
// Magic code goes here
	System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    prop = new Properties();
// Load configuration file.
    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
// Using the path we got above to to load the UI map
    prop.load(new FileInputStream(sSharedUIMapPath));
  }

  @Test
  public void testReservation() throws Exception {
	 driver.get(sAppURL);
	 Login(driver,"@","T123");
	 //Thread.sleep(3_000);
	 //verify username
	 assertEquals("The username is not yet registered", driver.findElement(By.xpath(prop.getProperty("Err_Login_Username"))).getAttribute("value"));
	 //verify password
	 assertEquals("Please Enter the correct password", driver.findElement(By.xpath(prop.getProperty("Err_Login_Password"))).getAttribute("value"));
	 Login(driver,"TusharNew","Tush123");
	
	 driver.findElement(By.linkText(prop.getProperty("Lnk_UserHomePage_SerchCar"))).click();
	 
	 Search(driver,"2018-12-01", "2018-11-30","10:00:00","09:00:00", "2");
	 Thread.sleep(1_000);
	assertEquals("The enddate ****** has to be after the start date", driver.findElement(By.xpath(prop.getProperty("Err_SearchCar_EndDate"))).getAttribute("value"));
	assertEquals("endtime should be greater than the start time", driver.findElement(By.xpath(prop.getProperty("Err_SearchCar_EndTime"))).getAttribute("value"));
	 //driver.findElement(By.linkText(prop.getProperty("Lnk_UserHomePage_SerchCar"))).click();
	 Search(driver,"2018-11-30", "2018-12-01","09:00:00","11:00:00", "2");
	 
	 
	 // wronge values of reserve
	 ReserveCar(driver, "SUV", "VISA","GPS", "101010", "05-19", "11");

	 assertEquals("Card number should be 16 digits", driver.findElement(By.xpath(prop.getProperty("Err_Reserve_CardNo"))).getAttribute("value"));
	 assertEquals("cvv number should be 3 digits", driver.findElement(By.xpath(prop.getProperty("Err_Reserve_Cvvno"))).getAttribute("value"));
	 
	 
	 driver.findElement(By.xpath(prop.getProperty("Btn_Payment_BookMyCar"))).click();
	 
	 // correct value
	 ReserveCar(driver, "SUV", "VISA","GPS", "1010101010101010", "05-19", "111");

	driver.findElement(By.xpath("html/body/a")).click();
	
	
	  
  }
 
 
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
