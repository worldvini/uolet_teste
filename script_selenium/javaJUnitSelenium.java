package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteUoletConsoleLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://console.uolet.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEUoletConsoleLogin() throws Exception {
    driver.get(baseUrl + "/editor/index.html");
    assertEquals("Uolet - editor de ofertas", driver.getTitle());
    // o formulario existe?
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("form-signin"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertTrue(isElementPresent(By.xpath("//img[@src='images/uolet-icon-120.png']")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Todos os campos do form estao carregados
    assertTrue(isElementPresent(By.xpath("//input[@id='username']")));
    try {
      assertEquals("Usuário", driver.findElement(By.cssSelector("#username")).getAttribute("placeholder"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.xpath("//input[@id='password']")));
    try {
      assertEquals("Senha", driver.findElement(By.cssSelector("#password")).getAttribute("placeholder"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.xpath("//input[@id='merchant']")));
    try {
      assertEquals("Lojista (sigla)", driver.findElement(By.cssSelector("#merchant")).getAttribute("placeholder"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.xpath("//button[@id='btn-login']")));
    try {
      assertEquals("Entrar", driver.findElement(By.xpath("//button[@id='btn-login']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
