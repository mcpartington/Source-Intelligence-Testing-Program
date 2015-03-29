package sitest;

/**
 * @author Maxwell Partington
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SItest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
  //public int i = 0;
  //public String[] websites = new String[] {"https://stage.sourceintelligence.net/login","https://stage.sourceintelligence.net/login", "https://www.google.com"};
  
  @Before
  public void setUp() throws Exception 
  {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setJavascriptEnabled(true);
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/Apple/Desktop/SItest/phantomjs-1.9.1-macosx/bin/phantomjs");
    Scanner scanner = new Scanner (System.in);
        
    System.out.println("Source intelligence sign in...");
    
    System.out.println("Please: enter your url:");
    baseUrl = scanner.nextLine();
    driver = new PhantomJSDriver(caps);
    //baseUrl = "https://stage.sourceintelligence.net/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void SItest() throws Exception 
  {
    //while ( i <= websites.length)
    //{
    System.out.println("Opening webpage: " + /*websites[i]*/baseUrl);
    driver.get(/*websites[i]*/baseUrl);
    System.out.println("Entering username: exampleusername");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("exampleusername");
    System.out.println("Entering password:  examplepassword");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("examplepassword");
    System.out.println("Submitting...");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("Profile")).click();
    driver.findElement(By.linkText("View")).click();
    driver.findElement(By.linkText("Intelligence")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    System.out.println("Returning home...");
    driver.findElement(By.linkText("Home")).click();
    //i++;
    //System.out.println(i);
    //}
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

