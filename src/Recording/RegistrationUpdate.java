package Recording;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationUpdate {
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
  public void testRegistrationUpdate() throws Exception {
    driver.get(baseUrl + "/CarRentalProject/");
    driver.findElement(By.linkText("New User")).click();
    driver.findElement(By.name("user_name")).clear();
    driver.findElement(By.name("user_name")).sendKeys("Zaid");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Zaid123");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Zaid");
    driver.findElement(By.name("license")).clear();
    driver.findElement(By.name("license")).sendKeys("DL123456");
    driver.findElement(By.name("Emai")).clear();
    driver.findElement(By.name("Emai")).sendKeys("Z@gmail.com");
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("28");
    driver.findElement(By.name("phno")).clear();
    driver.findElement(By.name("phno")).sendKeys("1004567567");
    driver.findElement(By.name("addr")).clear();
    driver.findElement(By.name("addr")).sendKeys("Test Address");
    driver.findElement(By.name("uta_id")).clear();
    driver.findElement(By.name("uta_id")).sendKeys("1001337755");
    driver.findElement(By.name("auto_club")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.name("user_name")).clear();
    driver.findElement(By.name("user_name")).sendKeys("Zaid");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Zaid123");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Zaid");
    driver.findElement(By.name("license")).clear();
    driver.findElement(By.name("license")).sendKeys("DL364567");
    driver.findElement(By.name("Emai")).clear();
    driver.findElement(By.name("Emai")).sendKeys("Z@gmail.com");
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("28");
    driver.findElement(By.name("phno")).clear();
    driver.findElement(By.name("phno")).sendKeys("1234567856");
    driver.findElement(By.name("addr")).clear();
    driver.findElement(By.name("addr")).sendKeys("Test ttt");
    driver.findElement(By.name("uta_id")).clear();
    driver.findElement(By.name("uta_id")).sendKeys("1001337755");
    driver.findElement(By.name("auto_club")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Zaid");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Zaid123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("TestAddr");
    driver.findElement(By.id("currentpassword")).clear();
    driver.findElement(By.id("currentpassword")).sendKeys("Zaid123");
    driver.findElement(By.id("newpassword")).clear();
    driver.findElement(By.id("newpassword")).sendKeys("Zaid12");
    driver.findElement(By.id("confirmpassword")).clear();
    driver.findElement(By.id("confirmpassword")).sendKeys("Zaid12");
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("Zaid@gmail.com");
    driver.findElement(By.id("currentpassword")).clear();
    driver.findElement(By.id("currentpassword")).sendKeys("Zaid123");
    driver.findElement(By.id("newpassword")).clear();
    driver.findElement(By.id("newpassword")).sendKeys("Zaid12");
    driver.findElement(By.id("confirmpassword")).clear();
    driver.findElement(By.id("confirmpassword")).sendKeys("Zaid12");
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
