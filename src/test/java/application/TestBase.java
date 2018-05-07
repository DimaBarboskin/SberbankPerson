package application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class TestBase {
    public static WebDriver driver;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static String firstUrl;

    @BeforeClass
    public static void setUp(){
      switch(properties.getProperty("browser")){
          case ("chrome"):
              System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver"));
              driver = new ChromeDriver();
              break;
          case ("firefox"):
              System.setProperty("webdriver.gecko.driver",properties.getProperty("webdriver.gecko.driver"));
              driver = new FirefoxDriver();
              break;
          default:
              System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver"));
              driver = new ChromeDriver();
      }
      firstUrl = properties.getProperty("first.url");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get(firstUrl);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
