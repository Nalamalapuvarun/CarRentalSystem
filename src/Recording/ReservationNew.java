package Recording;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReservationNew {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	// Magic code goes here
		System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testReservationNew() throws Exception {
    driver.get(baseUrl + "/CarRentalProject/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("TusharNew");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Tush123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Search car")).click();
    driver.findElement(By.name("startdate")).clear();
    driver.findElement(By.name("startdate")).sendKeys("2018-11-30");
    driver.findElement(By.name("enddate")).clear();
    driver.findElement(By.name("enddate")).sendKeys("2018-12-01");
    driver.findElement(By.name("starttime")).clear();
    driver.findElement(By.name("starttime")).sendKeys("09:00:00");
    driver.findElement(By.name("endtime")).clear();
    driver.findElement(By.name("endtime")).sendKeys("11:00:00");
    driver.findElement(By.name("capacity")).clear();
    driver.findElement(By.name("capacity")).sendKeys("4");
    driver.findElement(By.name("submit")).click();
    new Select(driver.findElement(By.name("database1"))).selectByVisibleText("FullSize");
    driver.findElement(By.name("GPS")).click();
    driver.findElement(By.name("cardno")).clear();
    driver.findElement(By.name("cardno")).sendKeys("1010101010101010");
    driver.findElement(By.name("vt")).clear();
    driver.findElement(By.name("vt")).sendKeys("05-19");
    driver.findElement(By.name("cvv")).clear();
    driver.findElement(By.name("cvv")).sendKeys("111");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("CLick Here")).click();
    driver.findElement(By.linkText("View My Reservation")).click();
    driver.findElement(By.name("startdate")).clear();
    driver.findElement(By.name("startdate")).sendKeys("2018-11-30");
    driver.findElement(By.id("enddate")).clear();
    driver.findElement(By.id("enddate")).sendKeys("2018-12-01");
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Cancel My Reservation")).click();
    driver.findElement(By.id("confirmationid")).clear();
    driver.findElement(By.id("confirmationid")).sendKeys("100056");
    driver.findElement(By.id("utaid")).clear();
    driver.findElement(By.id("utaid")).sendKeys("1001396298");
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.linkText("View My Reservation")).click();
    driver.findElement(By.name("startdate")).clear();
    driver.findElement(By.name("startdate")).sendKeys("2018-11-30");
    driver.findElement(By.id("enddate")).clear();
    driver.findElement(By.id("enddate")).sendKeys("2018-12-01");
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.name("submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
