package ftd.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FortudeAutomation {
	
    private WebDriver driver;
    
  @BeforeClass
  public void beforeClass() {

	  ClassLoader classLoader = FortudeAutomation.class.getClassLoader();
	  System.out.println(classLoader.getResource("chromedriver.exe").getPath());
	  System.setProperty("webdriver.chrome.driver",classLoader.getResource("chromedriver.exe").getPath().toString());
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  @Test
  public void testOpen() throws InterruptedException{

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://www.google.com");

      Thread.sleep(3000);
      String search_text = "Google Search";
      WebElement search_button = driver.findElement(By.name("btnK"));

      String text = search_button.getAttribute("value");

      Assert.assertEquals(text, search_text, "Text not found!");
      System.out.print("=======Test Case Executed ============");
  }

}
