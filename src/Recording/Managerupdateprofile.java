package Recording;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Managerupdateprofile {
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
  public void testManagerupdateprofile() throws Exception {
    driver.get(baseUrl + "/CarRentalProject/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Shilpi");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Shilps123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.xpath("html/body/form[2]/input")).click();
    driver.findElement(By.id("currentpassword")).clear();
    driver.findElement(By.id("currentpassword")).sendKeys("Shilps123");
    driver.findElement(By.id("newpassword")).clear();
    driver.findElement(By.id("newpassword")).sendKeys("Shilpi123");
    driver.findElement(By.id("confirmpassword")).clear();
    driver.findElement(By.id("confirmpassword")).sendKeys("Shilpi123");
    driver.findElement(By.xpath("html/body/form[2]/input")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Shilpi");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Shilpi123");
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
