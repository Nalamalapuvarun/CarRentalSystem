package Recording;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminRevokeRenter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminRevokeRenter() throws Exception {
    driver.get(baseUrl + "/CarRentalProject/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("prasanna");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Pras123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Revoke Renter")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Tushar");
    driver.findElement(By.cssSelector("td > input[name=\"submit\"]")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Tushar");
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
    driver.findElement(By.name("GPS")).click();
    driver.findElement(By.name("cardno")).clear();
    driver.findElement(By.name("cardno")).sendKeys("1010101010101010");
    driver.findElement(By.name("vt")).clear();
    driver.findElement(By.name("vt")).sendKeys("05-19");
    driver.findElement(By.name("cvv")).clear();
    driver.findElement(By.name("cvv")).sendKeys("111");
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
