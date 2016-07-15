/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lqas.automation;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 *
 * @author Sveta
 */
public class Mail {

  public Mail() {
  }
 
  WebDriver driver;
  List <WebElement>mailsList = new ArrayList();

  @BeforeSuite
  void open() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Java\\Lits Дз\\SeleniumTests\\src\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://mail.google.com");
	Thread.sleep(5000);
  }
  
 
  @Test(priority = 1)
  public void entrance() throws InterruptedException {
	driver.findElement(By.id("Email")).sendKeys("ytfdyug.com");
	Thread.sleep(5000);
	driver.findElement(By.id("next")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("Passwd")).sendKeys("nioadfhhoi");
	Thread.sleep(5000);
	driver.findElement(By.id("signIn")).click();
	Thread.sleep(5000);
  }
 
  
  @Test(priority = 2)
  public void getEmails() throws InterruptedException {
	Thread.sleep(5000);
	mailsList = driver.findElements(By.xpath(".//*//tbody//tr[@id]"));
  }

  
  @Test(priority = 3)
  public void search() {
	String textOfLetter, nameOfLatter;
	int index;
	for (int i = 0; i < mailsList.size(); i++) {
	  textOfLetter = mailsList.get(i).getText();
	  index = textOfLetter.indexOf('\n');
	  nameOfLatter = textOfLetter.substring(0, index);
	  int u = 1+1;
	  if ("Hello User".equals(nameOfLatter)) {
		System.out.println("//////////////////////////");
		System.out.println("The latter was finde");
		System.out.println("/////////////////////////");
		break;
	  }
	  
	  System.out.println(nameOfLatter);
	}
	System.out.println("The latter wasn't finde");
  }
  
  

  @AfterSuite
  void close() {
	driver.quit();
  }

}