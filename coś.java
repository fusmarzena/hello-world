package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Co {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCo() throws Exception {
    driver.get(baseUrl + "/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?access_type%3Doffline%26approval_prompt%3Dforce%26client_id%3D928534303614-covelkd2oa1ql30nbbgp3la966qoc85q.apps.googleusercontent.com%26redirect_uri%3Dhttps://shortlist-oauth.shortlist-test.net/oauth2/callback%26response_type%3Dcode%26scope%3Dprofile%2Bemail%26state%3D/marzena-fus.shortlist-test.net/%26from_login%3D1%26as%3D713f18910ac02b4a&oauth=1&sarp=1&scc=1#identifier");
    driver.findElement(By.xpath("//div/input[2]")).clear();
    driver.findElement(By.xpath("//div/input[2]")).sendKeys("wnpiZSBN27075");
    driver.findElement(By.xpath("//div/input")).clear();
    driver.findElement(By.xpath("//div/input")).sendKeys("marzena.fus@shortlist.co");
    driver.findElement(By.xpath("//form/div/div/input")).click();
    driver.findElement(By.xpath("//div[2]/div/input")).click();
  }

  @AfterClass(alwaysRun = true)
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
