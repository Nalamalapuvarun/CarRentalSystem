package Recording;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ManagerAddCar {
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
  public void testManagerAddCar() throws Exception {
    driver.get(baseUrl + "/CarRentalProject/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Shilpi");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Shilpi123");
    driver.findElement(By.name("submit")).click();
   
    driver.findElement(By.linkText("Add a Car")).click();
    driver.findElement(By.id("carname")).clear();
    driver.findElement(By.id("carname")).sendKeys("Abcd");
    driver.findElement(By.name("Capacity")).clear();
    driver.findElement(By.name("Capacity")).sendKeys("2");
    driver.findElement(By.id("gps")).clear();
    driver.findElement(By.id("gps")).sendKeys("10");
    driver.findElement(By.id("OnStar")).clear();
    driver.findElement(By.id("OnStar")).sendKeys("12");
    driver.findElement(By.id("SiriusXM")).clear();
    driver.findElement(By.id("SiriusXM")).sendKeys("10");
    driver.findElement(By.id("weekday")).clear();
    driver.findElement(By.id("weekday")).sendKeys("20");
    driver.findElement(By.id("weekend")).clear();
    driver.findElement(By.id("weekend")).sendKeys("25");
    driver.findElement(By.id("week")).clear();
    driver.findElement(By.id("week")).sendKeys("120");
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
