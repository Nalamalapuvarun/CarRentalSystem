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


public class MaintestAdmin extends CarRenterFunction {
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
  public void testManagerAddCar() throws Exception {
	 driver.get(sAppURL);
	 Login(driver,"prasanna","Pras123");
	 
	 driver.findElement(By.xpath(prop.getProperty("Lnk_AdminRevoke"))).click();
	 //wrongvalue
	 
	 AdminRevokeRenter(driver,"");
	 //driver.findElement(By.xpath("html/body/form[2]/input")).click();

	 Thread.sleep(1_000);
	  driver.findElement(By.xpath(prop.getProperty("Btn_RevokeRenter_Revoke"))).click();
	assertEquals("Your username must between 4 and 10 digits", driver.findElement(By.xpath(prop.getProperty("Err_RevokeUsername"))).getAttribute("value"));
	//correct
	AdminRevokeRenter(driver,"Tushar");
	  driver.findElement(By.xpath(prop.getProperty("Btn_RevokeRenter_Revoke"))).click();
	driver.findElement(By.id("logoutfromadmin")).click();
	 
	  Login(driver,"Tushar","Tush123");
	  driver.findElement(By.linkText(prop.getProperty("Lnk_UserHomePage_SerchCar"))).click();
	  Search(driver,"2018-11-30", "2018-12-01","09:00:00","11:00:00", "2");
	  ReserveCar(driver, "SUV", "VISA","GPS", "1010101010101010", "05-19", "111");
	  Thread.sleep(2_000);
	  driver.findElement(By.id("abc")).click();
	  //driver.findElement(By.xpath("html/body/a")).click();
	
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
