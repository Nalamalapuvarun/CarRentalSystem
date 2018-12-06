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


public class MaintestManagerAddCar extends CarRenterFunction {
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
	 Login(driver,"Shilpi","Shilpi123");
	 
	 driver.findElement(By.xpath(prop.getProperty("Lnk_Addcar_link"))).click();
	 //wrongvalue
	 
	 ManagerAddCar(driver,"Ab", "a","abc","", "","a","","a");
	 driver.findElement(By.xpath("html/body/form[2]/input")).click();

	 Thread.sleep(1_000);
	 
	assertEquals("You just have to enter numbers", driver.findElement(By.xpath(prop.getProperty("Err_addcar_capacity"))).getAttribute("value"));
	assertEquals("You just have to enter numbers", driver.findElement(By.xpath(prop.getProperty("Err_addcar_Gps"))).getAttribute("value"));
	assertEquals("Onstar can not be empty", driver.findElement(By.xpath(prop.getProperty("Err_adcar_Onstar"))).getAttribute("value"));
	assertEquals("SiriusXM can not be empty", driver.findElement(By.xpath(prop.getProperty("Err_addcar_siriusXM"))).getAttribute("value"));

	assertEquals("You just have to enter numbers", driver.findElement(By.xpath(prop.getProperty("Err_addcar_weekaday"))).getAttribute("value"));
	assertEquals("weekend rate can not be empty", driver.findElement(By.xpath(prop.getProperty("Err_addcar_weekend"))).getAttribute("value"));
	assertEquals("You just have to enter numbers", driver.findElement(By.xpath(prop.getProperty("Err_addcar_week"))).getAttribute("value"));

	
	//correct value
	ManagerAddCar(driver,"Abcd", "2","10","12", "10","20","25","120");
	 
	 
	 //driver.findElement(By.xpath(prop.getProperty("Btn_Addcar"))).click();
	 
	
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
